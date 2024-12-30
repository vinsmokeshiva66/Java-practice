public class Tictac {
    char tictac[][];

    Tictac(){
        this.tictac=new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tictac[i][j]='_';
            }
        }
    }


    public char check(char tictac[][]){
        for(int i=0;i<3;i++){
            int x_count=0;
            int o_count=0;
            for(int j=0;j<3;j++){
                if(tictac[i][j]=='X') x_count++;
                else if(tictac[i][j]=='O') o_count++;
            }
            if(x_count==3) return 'X';
            else if(o_count==3) return 'O';
        }

        for(int i=0;i<3;i++){
            int x_count=0;
            int o_count=0;
            for(int j=0;j<3;j++){
                if(tictac[j][i]=='X') x_count++;
                else if(tictac[j][i]=='O') o_count++;
            }
            if(x_count==3) return 'X';
            else if(o_count==3) return 'O';
        }

        for(int i=0;i<3;i++){
            int x_count=0;
            int o_count=0;
            for(int j=0;j<3;j++){
                if(i==j && tictac[i][j]=='X') x_count++;
                else if(i==j && tictac[i][j]=='O') o_count++;
            }
            if(x_count==3) return 'X';
            else if(o_count==3) return 'O';
        }

        for(int i=0;i<3;i++){
            int x_count=0;
            int o_count=0;
            for(int j=0;j<3;j++){
                if(i+j==3-1 && tictac[i][j]=='X') x_count++;
                else if(i+j==3-1 && tictac[i][j]=='O') o_count++;
            }
            if(x_count==3) return 'X';
            else if(o_count==3) return 'O';
        }
        return 'F';
    }

    public void print_board(){
        System.out.println("-----------------------");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(tictac[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
}
