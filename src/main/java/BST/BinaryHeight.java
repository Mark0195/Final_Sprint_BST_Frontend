package BST;

public class BinaryHeight {
    static <B> int getHeight(final BinaryNode<B> parent)
    {
        if (parent == null)
            return 0;

        final int leftHeight = getHeight(parent.left);
        final int rightHeight = getHeight(parent.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}