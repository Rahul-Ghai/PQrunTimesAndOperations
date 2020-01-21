public class WrappedInteger implements ComparableWrappedInteger 
{
  public int x;
  public static int counter = 0;
  public WrappedInteger (int x)
  {
    this.x = x;
    
  }
  @Override
  public int compareTo(WrappedInteger other)
  {
    counter++;
    return Integer.compare(this.x, other.x);
  }
  @Override
  public String toString()
  {
    return x + ;
  }
  public static void resetCount()
  {
    counter = 0;
  }
  public static int getCount()
  {
    return counter;
  }
}