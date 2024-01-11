class Solution {
    public long solution(int price, int money, int count) {
    	long total = 0;
        long answer = 0;
        
        for(int i=1; i<=count; i++) {
        	total += price * i;
        }
        
        if(money < total) { // 금액이 부족한 경우
        	answer = total-money;
        } else { // 금액이 부족하지 않을 경우
        	answer = 0;
        }
        
        return answer;
    }
}
