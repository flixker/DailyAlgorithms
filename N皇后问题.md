## N皇后问题



### 简述

n * n 的棋盘上放 n 个皇后，共有多少种放法？

在《指南》上看到的位运算解法，简洁明了。



### 代码



```java
public int nQueens(int n){
    if(n < 1 | n > 32){
        return 0;
    }
    int upperLim = n == 32 ? -1 : (1 << n) - 1;
    return process(upperLim, 0, 0, 0);
}

private int process(int upperLim, int colLim, int leftDiaLim, int rightDiaLim){
    if(upperLim == colLim){
        return 1;
    }
    int pos = 0;
    int mostRigthOne = 0;
    pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
    int res = 0;
    while(pos != 0){
        mostRightOne = pos & (~pos + 1);
        pos = pos - mostRightOne;
        res += process(upperLim, colLim | mostRightOne, 
                       (leftDiaLim | mostRightOne) << 1, 
                       (rightDiaLim | mostRightOne) >>> 1);
    }
    return res;
}
```

