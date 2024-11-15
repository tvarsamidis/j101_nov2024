package gr.codehub.j101.p01jvm.reference;

import gr.codehub.j101.p01jvm.model.Webpage;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class WeakReferences {

    private static Map<String, Object> cachedPages = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        rememberPageWeak(new Webpage("example1.com", "Hello from example1.com"));
        rememberPage(new Webpage("example2.com", "Hello from example2.com"));
        rememberPageWeak(new Webpage("example3.com", "Hello from example3.com"));

        Webpage r1 = recallWebpage("example1.com");
        System.out.println("example1=" + r1.getContent());

        Webpage r2 = recallWebpage("example2.com");
        System.out.println("example2=" + r2.getContent());

        System.gc();
        Thread.sleep(10000);


        System.out.println("example1=" + r1.getContent());

        Webpage r3 = recallWebpage("example3.com");
        System.out.println("example3=" + r3.getContent());

    }

    private static void rememberPage(Webpage webpage) {
        cachedPages.put(webpage.getUrl(), webpage);
    }

    private static void rememberPageWeak(Webpage webpage) {
        cachedPages.put(webpage.getUrl(), new WeakReference(webpage));
    }

    private static Webpage recallWebpage(String url) {
        Object o = cachedPages.get(url);
        if (o == null) {
            return null;
        }
        if (o instanceof Webpage) {
            return (Webpage)o;
        }
        if (o instanceof WeakReference) {
            return ((WeakReference<Webpage>)o).get();
        }
        return null;
    }
}
