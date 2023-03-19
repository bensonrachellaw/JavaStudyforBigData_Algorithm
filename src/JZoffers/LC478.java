package JZoffers;

public class LC478 {
    public static void main(String[] args) {
        SolutionLC478 obj = new SolutionLC478(1.0,0,0);
    }

}

/**
 * 逻辑很简单，在圆的外接正方形内随机，判断在圆外部的时候重新随机即可。这样概率不会出问题。 道理也显而易见。
 * 为了在一个半径为 RR 的圆 CC 中均匀随机生成点，我们可以使用拒绝采样的方法。
 * 我们使用一个边长为 2R2R 的正方形覆盖住圆 CC，并在正方形内随机生成点，若该点落在圆内，我们就返回这个点，否则我们拒绝这个点，重新生成知道新的随机点落在圆内。
 */
class SolutionLC478 {
    double rad , xc ,yc;
    public SolutionLC478(double radius, double x_center, double y_center) {
        rad = radius;
        xc = x_center;
        yc = y_center;
    }

    public double[] randPoint() {
        double x0 = xc - rad;
        double y0 = yc - rad;
        //找到正方形的左下角的点的坐标。
        while (true) {
            double ans_x = x0 + Math.random()*(2*rad);//[0,1)：Math.random()
            double ans_y = y0 + Math.random()*(2*rad);
            if (Math.sqrt(Math.pow(ans_x-xc,2)+Math.pow(ans_y-yc,2)) <= rad){
                return new double[]{ans_x,ans_y};
            }
        }
    }
}
