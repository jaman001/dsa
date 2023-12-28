package test;
public class TetrisChallenge {

    public static void main(String[] args) {
        // Example usage
        String[] strArr = {"L", "3", "4", "4", "5", "6", "2", "0", "6", "5", "3", "6", "6"};

        int result = arrayChallenge(strArr);
        System.out.println("Maximum number of horizontal lines: " + result);
    }

    private static int arrayChallenge(String[] strArr) {
        // Extract Tetris piece type and its structure
        String pieceType = strArr[0];
        int[] pieceStructure = new int[12];
        for (int i = 0; i < 12; i++) {
            pieceStructure[i] = Integer.parseInt(strArr[i + 1]);
        }

        // Validate piece type
        if (!isValidPieceType(pieceType)) {
            System.out.println("Invalid Tetris piece type");
            return 0;
        }

        int maxLines = 0;

        // Iterate through all rotations and horizontal positions
        for (int rotation = 0; rotation < 4; rotation++) {
            for (int position = 0; position <= 12 - pieceStructure.length; position++) {
                int[] currentBoard = new int[12];

                // Simulate the piece falling and calculate the board state
                for (int i = 0; i < pieceStructure.length; i++) {
                    int currentHeight = pieceStructure[i];
                    int currentColumn = position + i;
                    currentBoard[currentColumn] = Math.max(currentBoard[currentColumn], currentHeight);
                }

                // Calculate the number of completed lines for the current configuration
                int completedLines = countCompletedLines(currentBoard);

                // Update the maximum if the current configuration is better
                maxLines = Math.max(maxLines, completedLines);
            }

            // Rotate the piece for the next iteration
            pieceStructure = rotatePiece(pieceStructure);
        }

        return maxLines;
    }

    private static boolean isValidPieceType(String pieceType) {
        // Check if the piece type is valid (I, J, L, O, S, T, Z)
        return pieceType.matches("[IJLOSTZ]");
    }

    private static int countCompletedLines(int[] board) {
        int completedLines = 0;
        for (int height : board) {
            if (height == 4) {
                completedLines++;
            }
        }
        return completedLines;
    }

    private static int[] rotatePiece(int[] pieceStructure) {
        // Rotate the piece structure (shift the array elements)
        int[] rotatedPiece = new int[pieceStructure.length];
        for (int i = 0; i < pieceStructure.length; i++) {
            rotatedPiece[i] = pieceStructure[pieceStructure.length - 1 - i];
        }
        return rotatedPiece;
    }
}