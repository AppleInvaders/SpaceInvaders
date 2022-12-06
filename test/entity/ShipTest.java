package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    private Ship ship;
    
    @BeforeEach
    void setUp() {
        this.ship = new Ship(0, 300, Color.yellow);
    }

    @Test
    @DisplayName("위로 이동")
    void moveTop() {
        this.ship.moveTop();
        assertEquals(298, this.ship.positionY);
    }

    @Test
    @DisplayName("아래로 이동")
    void moveBottom() {
        this.ship.moveBottom();
        assertEquals(302, this.ship.positionY);
    }

    @Test
    @DisplayName("Ship 속도 설정 후 상하이동")
    void setShipSpeedMoveTopBottom() {
        this.ship.setShipSpeed(5);
        this.ship.moveTop();
        assertAll(
                "multi",
                () -> assertEquals(295, this.ship.positionY),
                () -> assertEquals(5, this.ship.getSpeed())
        );
        this.ship.moveBottom();
        assertEquals(300, this.ship.positionY);
    }
}