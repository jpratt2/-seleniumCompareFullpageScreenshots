public class Utilities {

    static String convertUrlToFileName(String url){
        url = url.replaceFirst("https?://","");
        url = url.replaceAll("[?|*:<>\"/\\\\]","-");
        url = truncate(url,159);//Windows file name limit
        return url;
    }

    static String truncate(String value, int length) {
        // Ensure String length is shorter than size limit.
        if (value.length() > length) {
            return value.substring(0, length);
        } else {
            return value;
        }
        //resource: https://www.dotnetperls.com/truncate-java
    }

    static void echo(Object object){
        //used for debugging, logs a value to the console
        System.out.println("*********begin echo**********");
        System.out.println(object);
        System.out.println("*********end echo**********");
    }
}
