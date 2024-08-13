package week3;

import org.junit.*;
public class LinkedListTest {
    private LinkedList<String> list;
    @Before
    public void setup()
    {
        this.list = new LinkedList<String>();
    }
    @Test
    public void testInitialListIsEmpty()
    {
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testSize_oneElement_sizeIsOne()
    {
        list.add("a");
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void testGet_OneElement()
    {
        list.add("a");
        String value = list.get(0);
        Assert.assertEquals("a", value);
    }

    @Test
    public void testSize_addSecondElement()
    {
        list.add("b");
        list.add("b");
        Assert.assertEquals(2,list.size());
    }

    @Test
    public void testGet_twoElements()
    {
        givenAListContaining("a", "b");
        String result = list.get(1);
        Assert.assertEquals("b", result);
    }

    private void givenAListContaining(String... elements) {
        for(String s: elements)
            list.add(s);
    }

    @Test
    public void testRemove_firstElementFromList()
    {
        givenAListContaining("a","b");
        String result = this.list.remove(0);
        Assert.assertEquals("a", result);
    }

    @Test
    public void testContains_containElementFromList()
    {
        givenAListContaining("a","b");
        String element = "b";
        Assert.assertEquals(true, this.list.contains(element));
    }
    @Test
    public void testContains_elementFromList() {
        givenAListContaining("a", "b");
        Assert.assertTrue("Списъкът трябва да съдържа 'b'.", this.list.contains("b"));
    }
    @Test
    public void testGet_withInvalidIndex() {
        givenAListContaining("a", "b");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
    }
    @Test
    public void testSize_afterAddingTwoElements() {
        list.add("x");
        list.add("y");
        Assert.assertEquals("Размерът трябва да бъде 2 след добавяне на два елемента.", 2, list.size());
    }
    @Test
    public void testGet_fromEmptyList() {
        Assert.assertNull("Вземането от празен списък трябва да върне null.", list.get(0));
    }

    @Test
    public void testReferenceEquality() {
        String sharedString = "shared";
        list.add(sharedString);
        list.add(sharedString);
        Assert.assertSame("Очакваме същата референция за идентични добавки на низове.", list.get(0), list.get(1));
    }



}
