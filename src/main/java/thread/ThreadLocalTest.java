package thread;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        /**
         * get()方法执行过程
         * 1、获取当前线程，在当前线程中取得ThreadLocalMap，如果ThreadLocalMap不为null，
         * 根据当前的ThreadLocal对象获取ThreadLocalMap中的Entry，取Entry中的value并返回
         * 2、如果一开始没有取到对象，再次获取ThreadLocalMap，
         * 如果ThreadLocalMap没有初始化，则初始化并将null值设置为当前ThreadLocal在ThreadLocalMap对应的值，
         * 如果初始化了则直接设置null值设置为当前ThreadLocal在ThreadLocalMap对应的值
         * set()方法的逻辑相似
         * Thread t = Thread.currentThread();
         ThreadLocalMap map = getMap(t);
         if (map != null) {
         ThreadLocalMap.Entry e = map.getEntry(this);
         if (e != null) {
        @SuppressWarnings("unchecked")
        T result = (T)e.value;
        return result;
        }
         }
         return setInitialValue();
         */
        String value = threadLocal.get();
        System.out.println(value);
    }

}
