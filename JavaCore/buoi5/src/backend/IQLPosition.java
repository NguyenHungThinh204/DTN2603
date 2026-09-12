package backend;
import entity.Position;
public interface IQLPosition {
    void hienThiPosition();

    void themPosition(Position position);

    void xoaPosition(int positionId);

    void suaPositionName(int positionId, String positionName);
}
