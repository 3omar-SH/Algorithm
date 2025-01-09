public class FloydWarshallProblem {
    final static int INF = 99999; // تمثل اللانهاية

    public static void main(String[] args) {
        // مصفوفة الإدخال
        int[][] graph = {
                {0, 3 , 2 , INF},
                {3, 0 , INF , 7},
                {2, INF , 0 , 1},
                {INF, 7 , 1 , 0}
        };
        // تطبيق الخوارزمية
        solveFloydWarshall(graph);
    }

    public static void solveFloydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        // نسخ مصفوفة الإدخال إلى المصفوفة النهائية
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // الخوارزمية
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        // طباعة النتيجة
        printMatrix(dist);
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        System.out.println("Matrix of shortest distances:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matrix[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}
/*
مثال توضيحي:
افترض أن لديك الرسم البياني التالي (يمثل المدن والمسافات بينها):

       (A)----3----(B)
        |           |
       2|           |7
        |           |
       (C)----1----(D)

    A	B	C	D
A	0	3	2	∞
B	3	0	∞	7
C	2	∞	0	1
D	∞	7	1	0
الهدف: إيجاد أقصر مسافة بين كل زوج من المدن.

حل المشكلة:
عند تشغيل الكود، ستحصل على الجدول النهائي الذي يحتوي على أقصر المسافات بين كل زوج من المدن.

المصفوفة النهائية:
    A	B	C	D
A	0	3	2	3
B	3	0	5	6
C	2	5	0	1
D	3	6	1	0
*/
