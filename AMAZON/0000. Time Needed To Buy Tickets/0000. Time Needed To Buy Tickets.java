public int timeRequiredToBuy(int[] tickets, int k) {
        int total=0;
        while (true){
            for(int i=0;i<tickets.length;i++){
                if(tickets[i]>0){
                    tickets[i]--;
                    total++;
                }
                if(tickets[k]==0){
                    return total;
                }

            }
        }
    }