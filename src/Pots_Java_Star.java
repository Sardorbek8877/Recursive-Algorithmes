public class Pots_Java_Star {

    public static void rearrangePots(int quantity, int start, int target){
        String[] locations = {"stove", "sink", "cupboard"};
        if (quantity > 0){
            rearrangePots(quantity-1, start, computeInterimPosition(start, target));

            System.out.println("pot " + ": " + locations[start] + " -> " + locations[target]);

            rearrangePots(quantity-1, computeInterimPosition(start, target), target);
        }
    }

    private static int computeInterimPosition( int start, int target ){
        return 3 - start - target;
    }

    private static boolean existsBalanceUpTo(int[] containers, int limit, int divergence, int unitsLoaded){
        if (unitsLoaded >= containers.length){
            return true;
        }

        int nextDivergence = divergence + containers[unitsLoaded];
        if (Math.abs( nextDivergence ) <= limit){
            boolean loadedOnPortSide = existsBalanceUpTo(containers, limit, nextDivergence, unitsLoaded+1);
            if ( loadedOnPortSide ){
                return true;
            }
        }
        nextDivergence = divergence - containers[unitsLoaded];
        if (Math.abs( nextDivergence ) <= limit){
            return existsBalanceUpTo( containers, limit, nextDivergence, unitsLoaded+1);
        }
        else {
            return false;
        }
    }
}
