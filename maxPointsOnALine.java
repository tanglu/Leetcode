/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
    public static int maxPoints(Point[] points) {
        
        if(points.length<=2) {
            return points.length;
        }
        //斜率
        double k = 0.0;
        int maxPointNum      = 0;
        int tempMaxPointNum  = 0;
        //坐标完全相同点的个数
        int samePointNum     = 0;
        //与x轴平行
        int parallelPointNum = 0; 
        HashMap<Double,Integer> slopeMap = new HashMap<Double,Integer>();
        for(int i=0;i<points.length-1;i++) {
            //代表起始点，会被累加上
            samePointNum     = 1;
            parallelPointNum = 0; 
            tempMaxPointNum  = 0;
            slopeMap.clear();
            for(int j=i+1;j<points.length;j++) {
                //坐标完全相同
                if((points[i].x == points[j].x)&&((points[i].y == points[j].y))) {
                    samePointNum++;
                    continue;
                }
                //与x轴平行
                if(points[i].x == points[j].x) {
                    parallelPointNum++;
                } else {
                    if(points[i].y == points[j].y) {
                        k = 0;
                    } else {
                        k = ((double)(points[i].y - points[j].y))/(points[i].x - points[j].x);
                    }
                    //斜率不存在
                    if(slopeMap.get(k)==null) {
                        slopeMap.put(k, new Integer(1));
                        if(1>tempMaxPointNum) {
                            tempMaxPointNum = 1;
                        }
                    }else {
                        //斜率已存在
                        int number = slopeMap.get(k);
                        number++;
                        slopeMap.put(k, new Integer(number));
                        if(number>tempMaxPointNum) {
                            tempMaxPointNum = number;
                        }
                    }
                }
            } //end of for
            
            if(parallelPointNum>1) {
                if(parallelPointNum>tempMaxPointNum) {
                    tempMaxPointNum = parallelPointNum;
                }
            }
            //加上起始点和具有相同坐标的点
            tempMaxPointNum += samePointNum;
            if(tempMaxPointNum>maxPointNum) {
                maxPointNum = tempMaxPointNum;
            }
        }
        return maxPointNum;
    }

在上几个测试用例：
        //Point[] array = { new Point(0,0)};
        //Point[] array = { new Point(0,0), new Point(0,0),new Point(0,0), new Point(0,0)};
        //Point[] array = { new Point(84,250), new Point(0,0) , new Point(1,0), new Point(0,-70), new Point(0,-70), new Point(1,-1), new Point(21,10), new Point(42,90),new Point(-42,-230)};
        //Point[] array = { new Point(0,0), new Point(0,1)};
        //Point[] array = { new Point(0,0), new Point(1,0)};
        //Point[] array = { new Point(1,1), new Point(1,2), new Point(1,3)};
        //Point[] array = { new Point(0,0), new Point(0,1), new Point(0,0)};
        //Point[] array = { new Point(2,3), new Point(3,3),new Point(-5,3)};
        Point[] array = {new Point(40,-23),new Point(9,138),new Point(429,115),new Point(50,-17),new Point(-3,80),new Point(-10,33),new Point(5,-21),new Point(-3,80),new Point(-6,-65),new Point(-18,26),new Point(-6,-65),new Point(5,72),new Point(0,77),new Point(-9,86),new Point(10,-2),new Point(-8,85),new Point(21,130),new Point(18,-6),new Point(-18,26),new Point(-1,-15),new Point(10,-2),new Point(8,69),new Point(-4,63),new Point(0,3),new Point(-4,40),new Point(-7,84),new Point(-8,7),new Point(30,154),new Point(16,-5),new Point(6,90),new Point(18,-6),new Point(5,77),new Point(-4,77),new Point(7,-13),new Point(-1,-45),new Point(16,-5),new Point(-9,86),new Point(-16,11),new Point(-7,84),new Point(1,76),new Point(3,77),new Point(10,67),new Point(1,-37),new Point(-10,-81),new Point(4,-11),new Point(-20,13),new Point(-10,77),new Point(6,-17),new Point(-27,2),new Point(-10,-81),new Point(10,-1),new Point(-9,1),new Point(-8,43),new Point(2,2),new Point(2,-21),new Point(3,82),new Point(8,-1),new Point(10,-1),new Point(-9,1),new Point(-12,42),new Point(16,-5),new Point(-5,-61),new Point(20,-7),new Point(9,-35),new Point(10,6),new Point(12,106),new Point(5,-21),new Point(-5,82),new Point(6,71),new Point(-15,34),new Point(-10,87),new Point(-14,-12),new Point(12,106),new Point(-5,82),new Point(-46,-45),new Point(-4,63),new Point(16,-5),new Point(4,1),new Point(-3,-53),new Point(0,-17),new Point(9,98),new Point(-18,26),new Point(-9,86),new Point(2,77),new Point(-2,-49),new Point(1,76),new Point(-3,-38),new Point(-8,7),new Point(-17,-37),new Point(5,72),new Point(10,-37),new Point(-4,-57),new Point(-3,-53),new Point(3,74),new Point(-3,-11),new Point(-8,7),new Point(1,88),new Point(-12,42),new Point(1,-37),new Point(2,77),new Point(-6,77),new Point(5,72),new Point(-4,-57),new Point(-18,-33),new Point(-12,42),new Point(-9,86),new Point(2,77),new Point(-8,77),new Point(-3,77),new Point(9,-42),new Point(16,41),new Point(-29,-37),new Point(0,-41),new Point(-21,18),new Point(-27,-34),new Point(0,77),new Point(3,74),new Point(-7,-69),new Point(-21,18),new Point(27,146),new Point(-20,13),new Point(21,130),new Point(-6,-65),new Point(14,-4),new Point(0,3),new Point(9,-5),new Point(6,-29),new Point(-2,73),new Point(-1,-15),new Point(1,76),new Point(-4,77),new Point(6,-29)};
        //最后一个测试用例是leetCode上面最难AC的一个数据，正确答案应该是25
        System.out.println(LeetcodeMaxPointsOnALine.maxPoints(array));
