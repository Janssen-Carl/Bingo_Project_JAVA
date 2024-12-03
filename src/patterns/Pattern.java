package patterns;

import models.BingoCard;

public interface Pattern {
   boolean matches(BingoCard card);
}
