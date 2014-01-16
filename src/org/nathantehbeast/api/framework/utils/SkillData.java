package org.nathantehbeast.api.framework.utils;

import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.context.Provider;
import org.powerbot.script.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */

@SuppressWarnings("ALL")
public class SkillData extends Provider {

    public static final int NUM_SKILL = 26;
    public final int[] initialExp = new int[NUM_SKILL];
    public final int[] initialLevels = new int[NUM_SKILL];

    private final Timer timer;

    public static enum Rate {
        MINUTE(60000d),
        HOUR(3600000d),
        DAY(86400000d),
        WEEK(604800000d);

        public final double time;

        Rate(double time) {
            this.time = time;
        }

        /**
         * Gets the time for this rate.
         *
         * @return this rate's time
         */
        public double getTime() {
            return time;
        }
    }

    public SkillData(Context arg0) {
        super(arg0);
        for (int i = 0; i < NUM_SKILL; i++) {
            initialExp[i] = ctx.skills.getExperience(i);
            initialLevels[i] = ctx.skills.getRealLevel(i);
        }
        this.timer = new Timer(0);
    }

    /**
     * Calculates the experience gained for the given skill index.
     *
     * @param index the skill index
     * @return the experience gained
     */
    public int experience(final int index) {
        if (index < 0 || index > NUM_SKILL) {
            throw new IllegalArgumentException("0 > index < " + NUM_SKILL);
        }
        return ctx.skills.getExperience(index) - initialExp[index];
    }

    /**
     * Calculates the experience gained for the given skill index at the given rate.
     *
     * @param rate  the rate in which to calculate the experience gained
     * @param index the skill index
     * @return the experience gained at the given rate
     */
    public int experience(final Rate rate, final int index) {
        return (int) (experience(index) * rate.time / timer.getElapsed());
    }

    /**
     * Calculates the number of levels gained for the given skill index.
     *
     * @param index the skill index
     * @return the number of levels gained
     */
    public int level(final int index) {
        if (index < 0 || index > NUM_SKILL) {
            throw new IllegalArgumentException("0 > index < " + NUM_SKILL);
        }
        return ctx.skills.getRealLevel(index) - initialLevels[index];
    }

    /**
     * Calculates the number of levels gained for the given skill index at the given rate.
     *
     * @param rate  the rate in which to calculate the number of levels gained
     * @param index the skill index
     * @return the number of levels gained at the given rate
     */
    public int level(final Rate rate, final int index) {
        return (int) (level(index) * rate.time / timer.getElapsed());
    }

    /**
     * Calculates the time to level up at the given rate for the given skill index.
     *
     * @param rate  the rate in which to calculate the time to level up
     * @param index the skill index
     * @return the estimated time to level up at the given rate
     */
    public long timeToLevel(final Rate rate, final int index) {
        final double exp = experience(rate, index);
        if (exp == 0d) {
            return 0l;
        }
        return (long) (ctx.skill.getExperienceToLevel(index, ctx.skills.getRealLevel(index) + 1) / exp * rate.time);
    }

}
