package generics;

public class ArrayTypeTest {

    public static void main(String[] args) {

        Long[] test = new Long[]{1L, 2L};
        System.out.println(test.getClass());    //class [Ljava.lang.Long;
        System.out.println(test.getClass().getComponentType());     //class java.lang.Long

        int[] primaryType = new int[]{1, 2};
        System.out.println(primaryType.getClass());     //class [I
        System.out.println(primaryType.getClass().getComponentType());      //int (int.class != Integer)

        //public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        //        @SuppressWarnings("unchecked")
        //        T[] copy = ((Object)newType == (Object)Object[].class)
        //            ? (T[]) new Object[newLength]
        //            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        //        System.arraycopy(original, 0, copy, 0,
        //                         Math.min(original.length, newLength));
        //        return copy;
        //}


        ///**
        //     * Returns the {@code Class} representing the component type of an
        //     * array.  If this class does not represent an array class this method
        //     * returns null.
        //     *
        //     * @return the {@code Class} representing the component type of this
        //     * class if this class is an array
        //     * @see     java.lang.reflect.Array
        //     * @since JDK1.1
        //     */
        //    public native Class<?> getComponentType();
    }


}
