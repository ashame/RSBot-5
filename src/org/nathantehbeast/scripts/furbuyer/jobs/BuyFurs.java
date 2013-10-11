package org.nathantehbeast.scripts.furbuyer.jobs;

import com.sk.util.time.TimedCondition;
import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.Npc;
import org.powerbot.script.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/11/13
 * Time: 3:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class BuyFurs extends Node {

    private Npc baraek;
    private final Component CHAT;

    public BuyFurs(Context ctx) {
        super(ctx);
        this.CHAT = ctx.widgets.get(1188, 12);
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public boolean activate() {
        return ctx.backpack.getMoneyPouch() > 20 && !ctx.inventory.isFull() && ctx.players.local().getLocation().distanceTo(new Tile(3218, 3435, 0)) <= 6;
    }

    @Override
    public void execute() {
        if ((baraek = ctx.npcs.select().id(547).poll()) != ctx.npcs.getNil()) {
            if (!ctx.chat.isChatting() && baraek.interact("Talk-to")) {
                new TimedCondition() {
                    @Override
                    public boolean check() {
                        return ctx.chat.select().first().text("you sell me some").poll().getText().contains("you sell me some");
                    }
                }.waitFor(1000);
                sleep(600);
            }
            if (ctx.keyboard.send("{VK_1}")) {
                sleep(600);
                new TimedCondition() {
                    @Override
                    public boolean check() {
                        return ctx.chat.isContinue();
                    }
                }.waitFor(1200);
                if (ctx.keyboard.send("{VK_SPACE}")) {
                    sleep(600);
                    new TimedCondition() {
                        @Override
                        public boolean check() {
                            return ctx.chat.isContinue();
                        }
                    }.waitFor(1200);
                    if (ctx.keyboard.send("{VK_SPACE}")) {
                        if (ctx.chat.select().first().text("Yeah, okay").poll().select()) {
                            sleep(600);
                            new TimedCondition() {
                                @Override
                                public boolean check() {
                                    return ctx.chat.isContinue();
                                }
                            }.waitFor(1200);
                            ctx.keyboard.send("{VK_SPACE}");
                            sleep(600);
                        }
                    }
                }
            }
        }
    }
}
