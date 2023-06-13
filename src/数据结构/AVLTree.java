package 数据结构;

public class AVLTree<T extends Comparable<T>> {
    public AVLTreeNode<T> root;

    static class AVLTreeNode<T extends Comparable<T>> {
        T key;
        int height;
        AVLTreeNode<T> lchild;
        AVLTreeNode<T> rchild;

        AVLTreeNode(T key, AVLTreeNode<T> lchild, AVLTreeNode<T> rchild) {
            this.key = key;
            this.lchild = lchild;
            this.rchild = rchild;
        }
    }

    private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
        if (tree == null) {
            tree = new AVLTreeNode<>(key, null, null);
        } else {
            int cmp = key.compareTo(tree.key);
            if (cmp < 0) {
                tree.lchild = insert(tree.lchild, key);
                if ((height(tree.lchild) - height(tree.rchild)) == 2) {
                    if (key.compareTo(tree.lchild.key) < 0) {
                        tree = LeftRotation(tree);
                    } else {
                        tree = LeftRightRotation(tree);
                    }
                }
            } else if (cmp > 0) {
                tree.rchild = insert(tree.rchild, key);
                if ((height(tree.rchild) - height(tree.lchild)) == 2) {
                    if (key.compareTo(tree.rchild.key) > 0) {
                        tree = RightRotation(tree);
                    } else {
                        tree = RightLeftRotation(tree);
                    }
                }
            } else {
                System.out.println("数据节点相同");
            }
        }
        tree.height = Math.max(height(tree.lchild), height(tree.rchild)) + 1;
        return tree;
    }

    public void insert(T key) {
        root = insert(root, key);
    }

    public AVLTreeNode<T> search(AVLTreeNode<T> root, T key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            return search(root.lchild, key);
        } else if (cmp > 0) {
            return search(root.rchild, key);
        } else {
            return root;
        }
    }


    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, T key) {

        AVLTreeNode<T> target = search(tree, key);

        if (tree == null || target == null) {
            return null;
        }
        int cmp = target.key.compareTo(tree.key);
        if (cmp < 0) {
            tree.lchild = remove(tree.lchild, target.key);
            if (height(tree.rchild) - height(tree.lchild) == 2) {
                AVLTreeNode<T> right = tree.rchild;
                tree = height(right.rchild) > height(right.lchild) ? RightRotation(tree) : RightLeftRotation(tree);
            }
        } else if (cmp > 0) {
            tree.rchild = remove(tree.rchild, target.key);
            if (height(tree.lchild) - height(tree.rchild) == 2) {
                AVLTreeNode<T> left = tree.lchild;
                tree = height(left.rchild) > height(left.lchild) ? LeftRightRotation(tree) : LeftRotation(tree);
            }
        } else {
            if ((tree.lchild != null) && (tree.rchild != null)) {
                if (height(tree.lchild) > height(tree.rchild)) {
                    AVLTreeNode<T> max = maximum(tree.lchild);
                    tree.key = max.key;
                    tree.lchild = remove(tree.lchild, max.key);
                } else {
                    AVLTreeNode<T> min = minimum(tree.rchild);
                    tree.key = min.key;
                    tree.rchild = remove(tree.rchild, min.key);
                }
            } else {
                tree = tree.lchild == null ? tree.rchild : tree.lchild;
            }
        }

        return tree;
    }


    public void remove(T key) {
        root = remove(root, key);
    }

    public AVLTreeNode<T> minimum(AVLTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        while (root.lchild != null) {
            root = root.lchild;
        }
        return root;
    }

    public AVLTreeNode<T> maximum(AVLTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        while (root.rchild != null) {
            root = root.rchild;
        }
        return root;
    }

    private int height(AVLTreeNode<T> tree) {
        if (tree != null) {
            return tree.height;
        }

        return 0;
    }

    private AVLTreeNode<T> LeftRotation(AVLTreeNode<T> node) {
        AVLTreeNode<T> left = node.lchild;
        node.lchild = left.rchild;
        left.rchild = node;
        node.height = Math.max(height(node.lchild), height(node.rchild)) + 1;
        left.height = Math.max(height(left.lchild), height(node)) + 1;
        return left;
    }

    private AVLTreeNode<T> RightRotation(AVLTreeNode<T> node) {
        AVLTreeNode<T> right = node.rchild;
        node.rchild = right.lchild;
        right.lchild = node;
        node.height = Math.max(height(node.lchild), height(node.rchild)) + 1;
        right.height = Math.max(height(right.rchild), height(node)) + 1;
        return right;
    }

    private AVLTreeNode<T> LeftRightRotation(AVLTreeNode<T> node) {
        node.lchild = RightRotation(node.lchild);
        return LeftRotation(node);
    }

    private AVLTreeNode<T> RightLeftRotation(AVLTreeNode<T> node) {
        node.rchild = LeftRotation(node.rchild);
        return RightRotation(node);
    }


}

