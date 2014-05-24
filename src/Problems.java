import java.util.*;

/**
 * Created by torrefra on 4/16/2014.
 */
public class Problems {

    public void multiplesOf3And5()
    {
        int[] arr = new int[1000];
        int arrayPos = 0;
        for (int i = 0; i < 1000; i++) {
            if(i%3 == 0  || i%5 == 0) {
                arr[arrayPos] = i;
                arrayPos++;
            }
        }

        int answer = 0;
        for (int i = 0; i < 1000; i++) {
            System.out.format("%d%n",arr[i]);
            answer += arr[i];
        }

        System.out.format("ANSWER = %d%n",answer);
    }

    public int[] evenFibonacciNumbers (int first, int second, int[] arrA)
    {
        if(first > 4000000) {
            return arrA;
        }

        System.out.format("%d%n",first);
        this.arrayPush(arrA,first);
        return this.evenFibonacciNumbers(second, first+second, arrA);
    }

    public int sumArray (int[] arrA)
    {
        int answer = 0;
        for (int i = 0; i < arrA.length; i++) {
            answer += arrA[i];
        }
        return answer;
    }

    public int[] arrayPush (int[] arrA, int value)
    {
        for (int i = 0; i < arrA.length; i++) {
            if(arrA[i] == 0) {
                arrA[i] = value;
                return arrA;
            }
        }

        return arrA;
    }

    public void arrayPrint (int[] arrA)
    {
        for (int i = 0; i < arrA.length; i++) {
            System.out.format("%d%n",arrA[i]);
        }
    }

    public int[] evenValues (int[] arrA)
    {
        int[] arrB = new int[arrA.length];
        int b = 0;

        for (int i = 0; i < arrA.length; i++) {
            if(arrA[i] % 2 == 0) {
                arrB[b] = arrA[i];
                b++;
            }
        }

        return arrB;
    }

    public int[] getPrimeNumbersList ()
    {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

        return primes;
    }

    public int findLargestPrimeNumber ( int startNum )
    {
        for (int i = startNum; i > 0; i--) {
            float div2 = (float)i/(float)2.0;
            float div3 = (float)i/(float)3.0;
            if ( div2%1 != 0 && div3%1 != 0 && i/i == 1) {
                System.out.format("%d%n",i);
                return i;
            }
        }

        return 0;
    }

    public List<Double> getPrimeNumbers ( long lastNum )
    {
        List<Double> primes = new ArrayList<Double>();
        primes.add((double)2);
        primes.add((double)3);

        for (long i = 5; i < lastNum; i++) {
            double div2 = (double)i/(double)2.0;
            double div3 = (double)i/(double)3.0;
            if ( div2%1 != 0 && div3%1 != 0 && i/i == 1) {
                System.out.format("%d%n",i);
                primes.add((double)i);
            }
        }

        System.out.format("%n%n%n%n%n%n%n");
        return primes;
    }

    public void findPrimeFactors ( long num )
    {
        List<Double> primes = new ArrayList<Double>();
        primes = this.getPrimeNumbers(num);

        //double[] primesArr = primes.toArray();

        for (int i = 0; i < primes.size(); i++) {
            if( num == 1 ) {
                return;
            }
            boolean stay = true;
            while(stay) {
                double prime = (Double)primes.get(i).doubleValue();
                double temp = (double)num / prime;
                if(temp % 1 == 0) {
                    System.out.format("%d%n",(long)prime);
                    num = (long)temp;
                } else {
                    stay = false;
                }
            }
        }
    }

    public int reverseInteger ( int num )
    {
        int x = num;
        int reverse = 0;
        while ( num != 0 ) {
            reverse = reverse * 10;
            reverse = reverse + (num % 10);
            num = num / 10;
        }

        return reverse;
    }

    public boolean isPalindrome ( int num )
    {
        int reverse = this.reverseInteger(num);

        if (reverse == num) {
            return true;
        } else {
            return false;
        }
    }

    public int largestPalindromeProduct ()
    {
        int largest = 0;
        for (int x = 999; x > 99; x--) {
            for (int y = 999; y > 99; y--) {
                int z = x * y;

                boolean result = this.isPalindrome(z);
                if (result) {
                    if ( z > largest ) {
                        largest = z;
                    }
                }
            }
        }

        return largest;
    }

    public double smallestMultiple()
    {
        double smallest = 0.0;
        double n = 1.0;

        while(smallest == 0.0) {
            boolean passed = false;
            checkDiv:
            for (double x = 1.0; x < 21.0; x++) {
                double y = n/x;
                double z = y%1.0;
                if(y != 0.0 && z == 0.0) {
                    passed = true;
                } else {
                    passed = false;
                    break checkDiv;
                }
            }

            if(passed) {
                smallest = n;
                return smallest;
            } else {
                n++;
            }
        }

        return smallest;
    }
}
