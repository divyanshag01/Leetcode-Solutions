class Solution {
    public int countPrimes(int n) {
        boolean primes[]=new boolean[n+1];
        return sieve(primes,n);
    }
    static int sieve(boolean  primes[], int n)
    {
        for (int i=2;i*i<n;i++)
        {
            if(!primes[i])
            {
                for(int j=i*2;j<n;j=j+i)
                primes[j]=true; //true means number is not prime
            }
        }
        int count=0;
        for(int i=2;i<n;i++)
        {
            if(!primes[i])
            count++;
        }
        return count;
    }
}