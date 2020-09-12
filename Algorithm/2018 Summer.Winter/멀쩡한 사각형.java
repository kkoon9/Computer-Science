class Solution {
  public long solution(int w, int h) {
    if (w == 1 || h == 1)
      return 0;
    long mul = (long) w * (long) h;
    long line = w + h - gcd(w, h);

    return mul - line;
  }

  int gcd(int w, int h) {
    return w % h == 0 ? h : gcd(h, w % h);
  }
}