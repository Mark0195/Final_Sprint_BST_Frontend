

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import BST.BinaryApp;
import BST.BinaryNode;
import org.junit.jupiter.api.Test;

class BinaryTests {
    @Test
    void testReconstruct() {
        ArrayList<Object> preorderValues = new ArrayList<Object>();
        assertNull(BinaryApp.<Object>reconstruct(preorderValues, new ArrayList<Object>()));
    }

    @Test
    void testReconstruct2() {
        ArrayList<Object> objectList = new ArrayList<Object>();
        objectList.add("42");
        assertThrows(IllegalStateException.class, () -> BinaryApp.<Object>reconstruct(objectList, new ArrayList<Object>()));
    }

    @Test
    void testReconstruct3() {
        ArrayList<Object> objectList = new ArrayList<Object>();
        objectList.add("42");

        ArrayList<Object> objectList1 = new ArrayList<Object>();
        objectList1.add("42");
        assertEquals("42", BinaryApp.<Object>reconstruct(objectList, objectList1).tree);
    }

    @Test
    void testReconstruct4() {
        BinaryNode<Integer> actualReconstructResult = BinaryApp.reconstruct(new int[]{42, 42, 42, 42});
        assertEquals(42, actualReconstructResult.tree.intValue());
        BinaryNode<Integer> bstNodes = actualReconstructResult.left;
        assertNull(bstNodes.right);
        Integer integer = actualReconstructResult.tree;
        BinaryNode<Integer> bstNodes1 = actualReconstructResult.right;
        assertSame(integer, bstNodes1.tree);
        assertNull(bstNodes1.right);
        assertSame(integer, bstNodes.tree);
        BinaryNode<Integer> bstNodes2 = bstNodes.left;
        assertSame(integer, bstNodes2.tree);
        assertNull(bstNodes2.right);
    }

    @Test
    void testReconstructClearer() {
        ArrayList<Object> preorderValues = new ArrayList<Object>();
        assertNull(BinaryApp.<Object>reconstructClearer(preorderValues, new ArrayList<Object>()));
    }

    @Test
    void testReconstructClearer2() {
        ArrayList<Object> objectList = new ArrayList<Object>();
        objectList.add("42");
        assertNull(BinaryApp.<Object>reconstructClearer(objectList, new ArrayList<Object>()));
    }

    @Test
    void testReconstructClearer3() {
        ArrayList<Object> objectList = new ArrayList<Object>();
        objectList.add("42");

        ArrayList<Object> objectList1 = new ArrayList<Object>();
        objectList1.add("42");
        assertEquals("42", BinaryApp.<Object>reconstructClearer(objectList, objectList1).tree);
    }

    @Test
    void testReconstructClearer4() {
        ArrayList<Object> objectList = new ArrayList<Object>();
        objectList.add("42");

        ArrayList<Object> objectList1 = new ArrayList<Object>();
        objectList1.add("42");
        objectList1.add("42");
        assertThrows(IllegalStateException.class, () -> BinaryApp.<Object>reconstructClearer(objectList, objectList1));
    }

    @Test
    void testReconstructClearer5() {
        ArrayList<Object> objectList = new ArrayList<Object>();
        objectList.add("42");
        objectList.add("42");

        ArrayList<Object> objectList1 = new ArrayList<Object>();
        objectList1.add("42");
        assertThrows(IllegalStateException.class, () -> BinaryApp.<Object>reconstructClearer(objectList, objectList1));
    }

    @Test
    void testDuplicates() {
        assertTrue(BinaryApp.duplicates(new int[]{1, 1, 1, 1}));
        assertFalse(BinaryApp.duplicates(new int[]{}));
    }
}
