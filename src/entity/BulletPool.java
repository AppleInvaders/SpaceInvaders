package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Implements a pool of recyclable bullets.
 * 
 * @author <a href="mailto:RobertoIA1987@gmail.com">Roberto Izquierdo Amo</a>
 * 
 */
public final class BulletPool {

	/** Set of already created bullets. */
	private static Set<Bullet> pool = new HashSet<Bullet>();
	private static Set<BossBullet> pool_1 = new HashSet<BossBullet>();
	/**
	 * Constructor, not called.
	 */
	private BulletPool() {

	}

	/**
	 * Returns a bullet from the pool if one is available, a new one if there
	 * isn't.
	 * 
	 * @param positionX
	 *            Requested position of the bullet in the X axis.
	 * @param positionY
	 *            Requested position of the bullet in the Y axis.
	 * @param speed
	 *            Requested speed of the bullet, positive or negative depending
	 *            on direction - positive is down.
	 * @return Requested bullet.
	 */
	public static Bullet getBullet(final int positionX,
			final int positionY, final int speed) {
		Bullet bullet;
		if (!pool.isEmpty()) {
			bullet = pool.iterator().next();
			pool.remove(bullet);
			bullet.setPositionX(positionX - bullet.getWidth() / 2);
			bullet.setPositionY(positionY);
			bullet.setSpeed(speed);
			bullet.setSprite();
		} else {
			bullet = new Bullet(positionX, positionY, speed);
			bullet.setPositionX(positionX - bullet.getWidth() / 2);
		}
		return bullet;
	}

	public static BossBullet getBossBullet(final int positionX,
								   final int positionY, final int speed) {
		BossBullet boss_bullet;
		if (!pool_1.isEmpty()) {
			boss_bullet = pool_1.iterator().next();
			pool_1.remove(boss_bullet);
			boss_bullet.setPositionX(positionX - boss_bullet.getWidth() / 2);
			boss_bullet.setPositionY(positionY);
			boss_bullet.setSpeed(speed);
			boss_bullet.setSprite();
		} else {
			boss_bullet = new BossBullet(positionX, positionY, speed);
			boss_bullet.setPositionX(positionX - boss_bullet.getWidth() / 2);
		}
		return boss_bullet;
	}

	/**
	 * Adds one or more bullets to the list of available ones.
	 * 
	 * @param bullet
	 *            Bullets to recycle.
	 */
	public static void recycle(final Set<Bullet> bullet) {
		pool.addAll(bullet);
	}
	public static void recycle_boss(final Set<BossBullet> boss_bullet) {
		pool_1.addAll(boss_bullet);
	}
}
