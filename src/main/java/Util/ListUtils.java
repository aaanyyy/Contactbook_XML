package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListUtils
{
    public static <T,R> R reduce(List<T> list,R init, BiFunction<R,T,R> f)
    {
        for (T t : list) {
            init= f.apply(init,t);

        }
        return init;

    }
    public static <T> boolean anyMatch(List<T>list,Predicate<T> predicate)
    {
        for (T t : list)
            if (predicate.test(t)) return true;
            return false;
    }
    public static <T> boolean allMatch(List<T> list, Predicate<T> predicate)
    {
        for (T t : list)
            if(!predicate.test(t)) return false;
            return true;

    }


    public static <T> List<T> map(List<T>incomingList,Function<T,T> function)
    {
        List<T> result=new ArrayList<>();
        for (T t : incomingList)
            result.add(function.apply(t));

        return result;
    }


    public static <T> void forEach(List<T> list, Consumer<T> consumer)
    {
        for (T t : list) {
            consumer.accept(t);
        }

    }



    public static<T> List <T>filter(List<T> incomingList, Predicate <T> predicate)
{
    List<T> result=new ArrayList<T>();
    {
        for (T elem : incomingList) {
            if(predicate.test(elem)) result.add(elem);
        }
        return result;
    }
}

}
