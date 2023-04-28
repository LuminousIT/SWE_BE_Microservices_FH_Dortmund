package com.roadside.assistance.warningservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CollisionWarning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double distanceToObstacle;
    private Double relativeSpeedToObstacle;
    private Double timeToCollision;
    private String typeOfObstacle;
    private String obstaclePosition;
    private Double obstacleSize;

    public CollisionWarning() {
    }

    public CollisionWarning(Double distanceToObstacle, Double relativeSpeedToObstacle, Double timeToCollision,
                            String typeOfObstacle, String obstaclePosition, Double obstacleSize) {
        this.distanceToObstacle = distanceToObstacle;
        this.relativeSpeedToObstacle = relativeSpeedToObstacle;
        this.timeToCollision = timeToCollision;
        this.typeOfObstacle = typeOfObstacle;
        this.obstaclePosition = obstaclePosition;
        this.obstacleSize = obstacleSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDistanceToObstacle() {
        return distanceToObstacle;
    }

    public void setDistanceToObstacle(Double distanceToObstacle) {
        this.distanceToObstacle = distanceToObstacle;
    }

    public Double getRelativeSpeedToObstacle() {
        return relativeSpeedToObstacle;
    }

    public void setRelativeSpeedToObstacle(Double relativeSpeedToObstacle) {
        this.relativeSpeedToObstacle = relativeSpeedToObstacle;
    }

    public Double getTimeToCollision() {
        return timeToCollision;
    }

    public void setTimeToCollision(Double timeToCollision) {
        this.timeToCollision = timeToCollision;
    }

    public String getTypeOfObstacle() {
        return typeOfObstacle;
    }

    public void setTypeOfObstacle(String typeOfObstacle) {
        this.typeOfObstacle = typeOfObstacle;
    }

    public String getObstaclePosition() {
        return obstaclePosition;
    }

    public void setObstaclePosition(String obstaclePosition) {
        this.obstaclePosition = obstaclePosition;
    }

    public Double getObstacleSize() {
        return obstacleSize;
    }

    public void setObstacleSize(Double obstacleSize) {
        this.obstacleSize = obstacleSize;
    }
}
