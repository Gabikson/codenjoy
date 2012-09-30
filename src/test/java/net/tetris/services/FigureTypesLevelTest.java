package net.tetris.services;

import net.tetris.dom.GlassEvent;
import net.tetris.dom.NullGameLevel;
import org.junit.Test;

import static net.tetris.dom.GlassEvent.Type.FIGURE_DROPPED;
import static net.tetris.dom.GlassEvent.Type.LINES_REMOVED;
import static net.tetris.dom.GlassEvent.Type.TOTAL_LINES_REMOVED;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * User: oleksandr.baglai
 * Date: 9/29/12
 * Time: 6:25 PM
 */
public class FigureTypesLevelTest {

    @Test
    public void validateNextLevelIngoingCriteria() {
        PlayerFigures queue = mock(PlayerFigures.class);

        assertEquals("Remove 4 lines together",
                new FigureTypesLevel(queue, new GlassEvent(LINES_REMOVED, 4)).getNextLevelIngoingCriteria());

        assertEquals("Total removes 13 lines",
                new FigureTypesLevel(queue, new GlassEvent(TOTAL_LINES_REMOVED, 13)).getNextLevelIngoingCriteria());

        assertEquals("This is last level",
                new FigureTypesLevel(queue, new GlassEvent(FIGURE_DROPPED, 0)).getNextLevelIngoingCriteria());

        assertEquals("This is last level",
                new NullGameLevel().getNextLevelIngoingCriteria());
    }
}
