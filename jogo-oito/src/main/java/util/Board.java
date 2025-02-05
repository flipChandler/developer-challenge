package util;

import interfaces.Graph;
import interfaces.Vertex;
import model.Matrix;

import java.util.*;

public class Board implements Graph {

    private List<Vertex> cells;
    private Vertex emptyCell;
    private Matrix matrix;
    private Integer currentCellValue;

    public Board() {
    }

    @Override
    public void feedback() {
        this.resetMatrix();
        this.defineEmptyCell();
    }

    @Override
    public void setting() {
        this.resetMatrix();
        this.shuffleCell();
        this.defineEmptyCell();
    }

    private void resetMatrix() {
        this.matrix = new Matrix();
        this.cells = this.matrix.getCells();
    }

    private void shuffleCell() {
        Iterator<Integer> iterator = this.shuffleValues().iterator();
        for (Vertex cell : this.cells) {
            cell.setValue(iterator.next());
        }
    }

    private List<Integer> shuffleValues() {
        List<Integer> values = new ArrayList<>();
        for (Vertex cell : this.cells) {
            values.add(cell.getValue());
        }
        Collections.shuffle(values);
        return values;
    }

    private void defineEmptyCell() {
        Optional<Vertex> minCell = this.cells.stream()
                .min(Comparator.comparing(cell -> cell.getValue()));
        minCell.ifPresent(cell -> {
            this.emptyCell = cell;
        });
    }

    @Override
    public List<Vertex> getCells() {
        return this.cells;
    }

    @Override
    public Vertex getEmptyCell() {
        return this.emptyCell;
    }

    @Override
    public void setEmptyCell(Vertex cell) {
        this.emptyCell = cell;
    }

    @Override
    public Integer getCurrentCellValue() {
        return this.currentCellValue;
    }

    @Override
    public void setCurrentCellValue(Integer currentCellValue) {
        this.currentCellValue = currentCellValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return cells.equals(board.cells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cells);
    }

}
