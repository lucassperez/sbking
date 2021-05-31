package br.com.sbk.sbking.core.boardrules.bridgeopenings;

import br.com.sbk.sbking.core.Board;
import br.com.sbk.sbking.core.Hand;
import br.com.sbk.sbking.core.HandEvaluations;
import br.com.sbk.sbking.core.boardrules.BoardRule;

public class DealerHasOneMajorOpeningBoardRule implements BoardRule {

    @Override
    public boolean isValid(Board board) {
        Hand dealerHand = board.getHandOf(board.getDealer());
        HandEvaluations handEvaluations = dealerHand.getHandEvaluations();
        boolean hasElevenPointsOpening = handEvaluations.getHCP() == 11
                && handEvaluations.hasSixOrMoreCardsInAMajorSuit();
        boolean hasNormalOpening = handEvaluations.getHCP() >= 12 && handEvaluations.getHCP() <= 21
                && handEvaluations.hasFiveOrMoreCardsInAMajorSuit();
        return hasElevenPointsOpening || hasNormalOpening;
    }

}
