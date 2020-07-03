import java.util.Random;
public class GameOfLife
{
   private int [][] g;
   private int [][] test;
   
   public GameOfLife(int row, int col)
   {
      this.g = new int[row][col];
      this.test = new int[row][col];

   }
   
   public int [][] getGrid()
   {
      return this.g;
   }
   
   public void nextIteration()
   {
      for ( int i = 1 ; i < this.g.length-1; i++)
      {
         for ( int j = 1 ; j < this.g[i].length-1; j++)
         {
            int live = 0;
            int dead = 0;
            
            if ( this.g[i][j] == 1 ) 
            {
               if(this.g[i][j-1] == 1 ) 
                  live++;
               if ((this.g[i][j+1] == 1))
                  live++;
               if ((this.g[i-1][j] == 1)) 
                  live++;
               if ((this.g[i+1][j] == 1))
                  live++;
               if ((this.g[i-1][j-1] == 1))
                  live++;
               if ((this.g[i+1][j+1] == 1))
                  live++;
               if ((this.g[i-1][j+1] == 1))
                  live++;
               if((this.g[i+1][j-1] == 1))
                  live++;
               
            }
            
            else if ( this.g[i][j] == 0 )            {
               if(this.g[i][j-1] == 1 ) 
                  dead++;
               if ((this.g[i][j+1] == 1))
                  dead++;
               if ((this.g[i-1][j] == 1)) 
                  dead++;
               if ((this.g[i+1][j] == 1))
                  dead++;
               if ((this.g[i-1][j-1] == 1))
                  dead++;
               if ((this.g[i+1][j+1] == 1))
                  dead++;
               if ((this.g[i-1][j+1] == 1))
                  dead++;
               if((this.g[i+1][j-1] == 1))
                  dead++;
               
             }
              
              if ( this.g[i][j] == 1 && (live < 2 || live > 3 ))
                  this.test[i][j] = 0;
              else if (this.g[i][j] == 1 && (live == 2 || live == 3))
                  this.test[i][j] = 1;
              else if ( this.g[i][j] == 0 && dead == 3 )
                  this.test[i][j] = 1;
              else
                  this.test[i][j] = 0;
                                    
         }
      }
      
      for ( int i = 0 ; i < this.g.length; i++)
      {
         for ( int j = 0 ; j < this.g[i].length; j++)
         {
            this.g[i][j] = this.test[i][j];
         }
      }
        
   }
   
   public void oscillatePatternInitialGrid()
   {
        for(int i = 1; i < g.length - 1; i++)
            {
               for(int j = 1; j < g[i].length -1; j++)
               {
                  if(i == (g.length - 2) / 2 && j == g[i].length / 2 || i == (g.length - 2) / 2 && j == (g[i].length / 2) - 1 || i == (g.length - 2) / 2 && j == (g[i].length / 2) + 1)
                     g[i][j] = 1;
               } 
             }          
   }
   
   public void blockPatternInitialGrid()
   {
      int centralRow = (this.g.length / 2 ) - 1;
      int centralCol = (this.g[0].length / 2) - 1;
      
      for ( int i = 0 ; i < this.g.length ; i++)
      {
         for ( int j = 0 ; j < this.g[i].length; j++)
         {
            this.g[i][j] = 0;                 
         }
      }

      
      for ( int i = 0 ; i < this.g.length ; i++)
      {
         for ( int j = 0 ; j < this.g[i].length; j++)
         {
            if ( i == centralRow && j == centralCol)
            {
               this.g[i][j] = 1;
               this.g[i+1][j] = 1;
               this.g[i][j+1] = 1;
               this.g[i+1][j+1] = 1;
            }
               
         }
      }

   }
   
   public void randomizeInitialGrid()
   {
      Random ran = new Random();
      for ( int i = 0 ; i < this.g.length ; i++)
      {
         for ( int j = 0 ; j < this.g[i].length; j++)
         {
            this.g[i][j] = ran.nextInt(2);                
         }
      }
 
   }
   
}