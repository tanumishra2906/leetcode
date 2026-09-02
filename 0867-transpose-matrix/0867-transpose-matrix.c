/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** transpose(int** matrix, int matrixSize,
                int* matrixColSize,
                int* returnSize,
                int** returnColumnSizes)
{
    int i,j;

    int row = matrixSize;
    int col = matrixColSize[0];

    *returnSize = col;

    *returnColumnSizes = (int*)malloc(col*sizeof(int));

    for(i=0;i<col;i++)
    {
        (*returnColumnSizes)[i]=row;
    }

    int **mat2=(int**)malloc(col*sizeof(int*));

    for(i=0;i<col;i++)
    {
        mat2[i]=(int*)malloc(row*sizeof(int));

        for(j=0;j<row;j++)
        {
            mat2[i][j]=matrix[j][i];
        }
    }

    return mat2;
}