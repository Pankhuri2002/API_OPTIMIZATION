package com.example.optimizationapi.service;

import com.example.optimizationapi.model.Move;
import com.example.optimizationapi.model.MovePlanRequest;
import com.example.optimizationapi.model.MovePlanResponse;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptimizationService {

    public MovePlanResponse optimize(MovePlanRequest request) {
        List<Move> optimizedMoves = request.getMoves()
                .stream()
                .sorted(Comparator.comparingInt(Move::getWeight))
                .collect(Collectors.toList());

        return new MovePlanResponse(optimizedMoves);
    }
}

package com.example.optimizationapi.model;

import java.util.List;

public class MovePlanRequest {
    private List<Move> moves;

    public List<Move> getMoves() { return moves; }
    public void setMoves(List<Move> moves) { this.moves = moves; }
}

package com.example.optimizationapi.model;

import java.util.List;

public class MovePlanResponse {
    private List<Move> optimizedMoves;
    private double latencyMs;

    public MovePlanResponse(List<Move> optimizedMoves) {
        this.optimizedMoves = optimizedMoves;
    }

    public List<Move> getOptimizedMoves() { return optimizedMoves; }
    public void setOptimizedMoves(List<Move> optimizedMoves) { this.optimizedMoves = optimizedMoves; }

    public double getLatencyMs() { return latencyMs; }
    public void setLatencyMs(double latencyMs) { this.latencyMs = latencyMs; }
}