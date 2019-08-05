import spock.lang.Specification

class HelloWorldSpec extends Specification
{
  def setup()
  {
    println 'Setting up HelloWorldSpec'
  }

  def 'maximum of two numbers'(int a, int b, int c)
  {
    given: 'two numbers a & b'
    expect: 'the sum of those numbers equals c'
    a + b == c

    where:
    a | b | c
    1 | 2 | 3
    2 | 2 | 4
    4 | 2 | 6
    1 | 6 | 7
  }
}
