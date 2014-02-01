public int singleNumber(int[] A) {
  int result = 0;
  for (int i=0;i<A.length;i++) {
    result = result ^ A[i];
  }
  return result;
}
