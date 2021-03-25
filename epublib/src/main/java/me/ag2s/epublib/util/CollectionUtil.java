package me.ag2s.epublib.util;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class CollectionUtil {

  /**
   * Wraps an Enumeration around an Iterator
   * @author paul.siegmann
   *
   * @param <T>
   */
  private static class IteratorEnumerationAdapter<T> implements Enumeration<T> {

    private Iterator<T> iterator;

    public IteratorEnumerationAdapter(Iterator<T> iter) {
      this.iterator = iter;
    }

    @Override
    public boolean hasMoreElements() {
      return iterator.hasNext();
    }

    @Override
    public T nextElement() {
      return iterator.next();
    }
  }

  /**
   * Creates an Enumeration out of the given Iterator.
   * @param <T>
   * @param it
   * @return an Enumeration created out of the given Iterator.
   */
  public static <T> Enumeration<T> createEnumerationFromIterator(
      Iterator<T> it) {
    return new IteratorEnumerationAdapter<T>(it);
  }


  /**
   * Returns the first element of the list, null if the list is null or empty.
   *
   * @param <T>
   * @param list
   * @return the first element of the list, null if the list is null or empty.
   */
  public static <T> T first(List<T> list) {
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  /**
   * Whether the given collection is null or has no elements.
   *
   * @param collection
   * @return Whether the given collection is null or has no elements.
   */
  public static boolean isEmpty(Collection<?> collection) {
    return collection == null || collection.isEmpty();
  }
}
