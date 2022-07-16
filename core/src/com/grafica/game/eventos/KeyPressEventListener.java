package com.grafica.game.eventos;

import java.util.EventListener;

public interface KeyPressEventListener extends EventListener {
    public abstract void onKeyPress(char character);
}
