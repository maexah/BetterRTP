package me.SuperRonanCraft.BetterRTP.player.rtp.effects;

import me.SuperRonanCraft.BetterRTP.BetterRTP;
import me.SuperRonanCraft.BetterRTP.references.file.FileOther;
import me.SuperRonanCraft.BetterRTP.versions.AsyncHandler;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RTPEffect_Particles {

    private boolean enabled;
    private final List<Particle> effects = new ArrayList<>();
    private String shape;
    private final int precision = 16;

    //Some particles act very differently and might not care how they are shaped before animating, ex: EXPLOSION_NORMAL
    public static String[] shapeTypes = {
            "SCAN", //Body scan
            "EXPLODE", //Make an explosive entrance
            "TELEPORT" //Startrek type of portal
            };

    void load() {
        FileOther.FILETYPE config = getPl().getFiles().getType(FileOther.FILETYPE.EFFECTS);
        enabled = config.getBoolean("Particles.Enabled");
        if (!enabled) return;
        //Enabled? Load all this junk
        List<String> types;
        if (config.isList("Particles.Type"))
            types = config.getStringList("Particles.Type");
        else {
            types = new ArrayList<>();
            types.add(config.getString("Particles.Type"));
        }
        String typeTrying = null;
        try {
            for (String type : types) {
                typeTrying = type;
                effects.add(Particle.valueOf(type.toUpperCase()));
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            effects.clear();
            effects.add(Particle.ASH);
            getPl().getLogger().severe("The particle '" + typeTrying + "' doesn't exist! Default particle enabled... " +
                    "Try using '/rtp info particles' to get a list of available particles");
        } catch (ExceptionInInitializerError | NoClassDefFoundError e2) {
            effects.clear();
            getPl().getLogger().severe("The particle '" + typeTrying + "' created a fatal error when loading particles! Your MC version isn't supported!");
            enabled = false;
        }
        shape = config.getString("Particles.Shape").toUpperCase();
        if (!Arrays.asList(shapeTypes).contains(shape)) {
            getPl().getLogger().severe("The particle shape '" + shape + "' doesn't exist! Default particle shape enabled...");
            getPl().getLogger().severe("Try using '/rtp info shapes' to get a list of shapes, or: " + Arrays.asList(shapeTypes));
            shape = shapeTypes[0];
        }
    }

    public void display(Player p) {
        if (!enabled) return;
        AsyncHandler.async(() -> {
            try { //Incase the library errors out
                switch (shape) {
                    case "TELEPORT":
                        partTeleport(p);
                        break;
                    case "EXPLODE":
                        partExplosion(p);
                        break;
                    default: //Super redundant, but... just future proofing
                    case "SCAN":
                        partScan(p);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void partScan(Player p) { //Particles with negative velocity
        Location loc = p.getLocation().add(new Vector(0, 1.75, 0));
        for (int index = 1; index < precision; index++) {
            Vector vec = getVecCircle(index);
            for (Particle effect : effects) {
                displayDirectionalParticle(p, effect, loc.clone().add(vec), new Vector(0, -0.125, 0), 0.15d);
            }
        }
    }

    private void partTeleport(Player p) { //Static particles in a shape
        Location loc = p.getLocation();
        for (float y = 2.5f; y > 0; y -= .25f)
            for (int index = 1; index < precision; index++) {
                //double yran = ran.nextGaussian() * pHeight;
                Vector vec = getVecCircle(index).add(new Vector(0, y, 0));
                for (Particle effect : effects) {
                    displayStaticParticle(p, effect, loc.clone().add(vec));
                }
            }
    }

    private void partExplosion(Player p) { //Particles with a shape and forward velocity
        Location loc = p.getLocation().add(new Vector(0, 1, 0));
        for (int index = 1; index < precision; index++) {
            Vector vec = getVecCircle(index);
            for (Particle effect : effects) {
                displayDirectionalParticle(p, effect, loc.clone().add(vec), vec, 1.5d);
            }
        }
    }

    private Vector getVecCircle(int index) {
        double p1 = (index * Math.PI) / (precision / 2);
        double p2 = (index - 1) * Math.PI / (precision / 2);
        //Positions
        int radius = 3;
        double x1 = Math.cos(p1) * radius;
        double x2 = Math.cos(p2) * radius;
        double z1 = Math.sin(p1) * radius;
        double z2 = Math.sin(p2) * radius;
        return new Vector(x2 - x1, 0, z2 - z1);
    }

    private BetterRTP getPl() {
        return BetterRTP.getInstance();
    }

    private void displayStaticParticle(Player player, Particle particle, Location location) {
        player.spawnParticle(particle, location, 1, 0, 0, 0, 0);
    }

    private void displayDirectionalParticle(Player player, Particle particle, Location location, Vector direction, double speed) {
        player.spawnParticle(particle, location, 0, direction.getX(), direction.getY(), direction.getZ(), speed);
    }
}
