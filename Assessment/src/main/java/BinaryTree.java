// src/main/java/BinaryTree.java
public class BinaryTree {
    private class TreeNode {
        Vehicle vehicle;
        TreeNode left;
        TreeNode right;
        TreeNode(Vehicle v) {
            vehicle = v;
            left = null;
            right = null;
        }
    }

    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Vehicle vehicle) {
        root = insert(root, vehicle);
    }

    private TreeNode insert(TreeNode node, Vehicle vehicle) {
        if (node == null) return new TreeNode(vehicle);
        if (vehicle.type.compareTo(node.vehicle.type) < 0) {
            node.left = insert(node.left, vehicle);
        } else {
            node.right = insert(node.right, vehicle);
        }
        return node;
    }

    public Vehicle search(String type) {
        TreeNode result = search(root, type);
        return result != null ? result.vehicle : null;
    }

    private TreeNode search(TreeNode node, String type) {
        if (node == null || node.vehicle.type.equals(type)) return node;
        if (type.compareTo(node.vehicle.type) < 0) return search(node.left, type);
        return search(node.right, type);
    }
}
