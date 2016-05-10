package toy.puzzle.slide;

/**
 * 方块抽象类
 *
 * Created by cc on 16/5/9.
 */
public abstract class AbstractBlock {

    protected GridPoint leftBottomPoint;

    protected int width;

    protected int height;

    protected AbstractBlock(int height, GridPoint leftBottomPoint, int width) {
        this.height = height;
        this.leftBottomPoint = leftBottomPoint;
        this.width = width;
    }
}
