package backend.controller;
import backend.service.IPositionService;
import backend.service.implement.PositionServiceImplement;
import entity.Postion;

import java.util.List;

public class PostionController {
    IPositionService positionService;
    public PostionController() {
        positionService=new PositionServiceImplement();
    }
    public boolean kiemTraTonTaiPostionId(Integer positionId) {
        return positionService.kiemTraTonTaiPostionId(positionId);
    }
    Postion getPostionById(int positionId){
        return positionService.getPostionById(positionId);
    }

    public List<Postion> getPostions() {
        return positionService.getPostions();
    }
}
