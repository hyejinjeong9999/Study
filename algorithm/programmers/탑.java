//
//https://programmers.co.kr/learn/courses/30/lessons/42588
class Top {
    public static int[] topSolution(int[] heights) {
        int index = heights.length-1;
        int[] answer = new int[heights.length];
        // 54321 순으로 내려가기
        // 5랑 4랑 비교해서 4가 더 값이 크면 answer에 추가
        // 아니면 continue
        for (int i = heights.length-1; i >= 1; i--) {
            System.out.println("heights["+i+"] : " + heights[i]);
            for(int j = i-1; j>0; j--){
            System.out.println("heights["+j+"] : " + heights[j]);
                if(heights[i]>heights[j]) continue;
                else{
                    answer[index] = j;
                }

            }
            
            index--;
        
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] top1 = { 6, 9, 5, 7, 4 };
        int[] top2 = { 3, 9, 9, 3, 5, 7, 2 };
        int[] top3 = { 1, 5, 3, 6, 7, 6, 5 };

        int[] answer = topSolution(top1);
        for (int i : answer) {
            System.out.print(i + " ");
        }

    }
}
