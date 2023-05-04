package com.example.sudokosolver;
class sudokomethods{

    public boolean checkRow(int[][][] main,int n, int i, int k) {
        // same block check
        for (int q = 0; q < 3; q++) {
            if (main[k][i][q] == n) {
                return false;
            }
            continue;
        }

        // 2 prev
        if (k % 3 == 2) {
            for (int p = 1; p < 3; p++) {
                for (int q = 0; q < 3; q++) {
                    if (main[k-p][i][q] == n) {
                        return false;
                    }
                    continue;
                }
            }
        }

        // 1 prev and 1 ahead
        else if (k % 3 == 1) {
            for (int q = 0; q < 3; q++) {
                if (main[k-1][i][q] == n) {
                    return false;
                }
                continue;
            }
            for (int q = 0; q < 3; q++) {
                if (main[k+1][i][q] == n) {
                    return false;
                }
                continue;
            }
        }
        // 2 ahead
        if (k % 3 == 0) {
            for (int p = 1; p < 3; p++) {
                for (int q = 0; q < 3; q++) {
                    if (main[k + p][i][q] == n) {
                        return false;
                    }
                    continue;
                }
            }
        }
        return true;

    }

    public boolean checkCol(int[][][] main,int n, int j, int k) {
        int x = k % 3;
        for (int q = 0; q < 9; q++) {
            if (x == q % 3) {
                for (int p = 0; p < 3; p++) {
                    if (main[q][p][j] == n) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkBlock(int[][][] main,int n, int k) {
        for (int p = 0; p < 3; p++) {
            for (int q = 0; q < 3; q++) {
                if (main[k][p][q] == n) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(int[][][] main,int n, int i, int j, int k){

        if (checkBlock(main,n,k) && checkCol(main,n,j,k) && checkRow(main,n,i,k)){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean fill(int[][][] main){
        boolean isEmpty = true;
        int l = -1;
        int m = -1;
        int p = -1;
        for (int k=0;k<9;k++){
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    if (main[k][i][j] == 0){
                        isEmpty = false;
                        l=k;
                        m=i;
                        p=j;
                        break;
                    }
                }
                if (!isEmpty){
                    break;
                }
            }
            if (!isEmpty){
                break;
            }
        }
        if(isEmpty){
            return true;
        }
        for (int n=1; n<10; n++){
            if (isSafe(main,n,m,p,l)){
                main[l][m][p] = n;
                if (fill(main)){
                    return true;
                }
                else{
                    main[l][m][p] = 0;
                }
            }
        }
        return false;

    }

}



