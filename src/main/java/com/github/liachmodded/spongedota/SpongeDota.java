/*
 * This file is part of SpongeDota, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2016 - 2016 liach
 * Copyright (c) Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.liachmodded.spongedota;

import static com.github.liachmodded.spongedota.Constants.DEPENDENCIES;
import static com.github.liachmodded.spongedota.Constants.PLUGIN_ID;
import static com.github.liachmodded.spongedota.Constants.PLUGIN_NAME;
import static com.github.liachmodded.spongedota.Constants.VERSION;

import com.google.inject.Inject;
import me.flibio.minigamecore.Minigame;
import net.minecrell.mcstats.SpongeStatsLite;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.plugin.Plugin;

/**
 * The main class of Sponge Dota plugin.
 */
@Plugin(id = PLUGIN_ID, name = PLUGIN_NAME, version = VERSION, dependencies = DEPENDENCIES)
public final class SpongeDota {

    private static SpongeDota instance;
    private Minigame dotaGame;

    @Inject
    private SpongeStatsLite statsLite;

    protected SpongeDota() {
        instance = this;
    }

    public static SpongeDota getInstance() {
        return instance;
    }

    public void onPreInit(GamePreInitializationEvent event) {
        this.statsLite.start();
    }

    public void onServerStart(GameStartingServerEvent event) {
        this.dotaGame = new Minigame("dota", Sponge.getGame(), LoggerFactory.getLogger(PLUGIN_NAME));
    }

}
