package facade;

import command.Command;
import interfaces.Graph;
import interfaces.Status;
import interfaces.Vertex;
import util.Board;
import util.Click;
import util.GameStatus;

import java.util.List;

public class Controller {

    private final Graph board;
    private final Status gameStatus;
    private final Command click;

    public Controller() {
        this.board = new Board();
        this.gameStatus = GameStatus.of(this.board);
        this.click = Click.of(this.board);
    }
    
    public void feedback() {
        this.board.feedback();
    }

    public void setting() {
        this.board.setting();
    }

    public List<Vertex> getCells() {
        return this.board.getCells();
    }

    public Boolean checkGameOver() {
        return this.gameStatus.isOver();
    }

    public void click(Integer currentCellValue) {
        this.board.setCurrentCellValue(currentCellValue);
        this.click.execute();
    }

}
