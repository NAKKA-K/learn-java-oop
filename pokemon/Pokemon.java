package pokemon;
import java.util.Arrays;
import skills.Skill;
import statuses.NormalStatus;
import statuses.Status;

public abstract class Pokemon {
    String tribeName; // 種族名
    String nickName; // ニックネーム

    int hitPoint; // 体力
    int attack; // 攻撃
    int block; // 防御
    int concentration; // 特攻
    int defence; // 特防
    int speed; // 素早さ

    Status status = new NormalStatus();
    Skill skills[] = new Skill[4];

    public Pokemon(String tribeName, String nickName, int hitPoint, int attack, int block, int concentration, int defence, int speed, Skill skills[]) {
        this.tribeName = tribeName;
        this.nickName = nickName;
        this.hitPoint = hitPoint;
        this.attack = attack;
        this.block = block;
        this.concentration = concentration;
        this.defence = defence;
        this.speed = speed;
        Arrays.stream(skills).forEach(s -> this.setSkill(s));
    }

    // 攻撃を受けた時に実行するメソッド
    // 本当なら効果抜群や効果なし、通常などのパターンで戻り値を設計する必要あり
    public boolean wasAttacked(Skill skill) {
        if(skill == null) {
            return false;
        }

        // 技の成否を確かめる(タイプ、相手の居場所、天気、命中率)
        int damage = skill.calcDamage();
        if(damage == 0) {
            return false; // 効果なし
        }

        this.applyDamage(damage); // ダメージ判定
        // 特殊効力(麻痺や混乱の発動判定)

        return true;
    }

    private void applyDamage(int damage) {
        this.hitPoint -= (damage / 10);
        if(this.hitPoint < 0) {
            this.hitPoint = 0;
        }
    }

    public Skill attack(int skillNum) {
        Skill skill = this.skills[skillNum];
        System.out.println(this.tribeName + "は" + skill.getName() + "を繰り出した！");
        // 攻撃を発動できるか判定し、できなければnullを返す(混乱や麻痺などの自分のステータスによって出る影響)
        // タイプ一致や攻撃力などでskillのダメージ補正
        if(!this.status.canMove()) {
            return null;
        }

        return skill;
    }

    public void setSkill(Skill skill) {
        for(int i = 0; i < this.skills.length; i++) {
            if(this.skills[i] == null) {
                this.skills[i] = skill;
                return;
            }
        }
    }

    public boolean setSkill(Skill skill, int settingNum) {
        this.skills[settingNum] = skill;
        return true;
    }

    public String formatedStatus() {
        return String.format(
            "名前: %s, HP: %d, こうげき: %d, ぼうぎょ: %d, とくこう: %d, とくこう: %d, すばやさ: %d,",
            this.tribeName, this.hitPoint, this.attack, this.block, this.concentration, this.defence, this.speed);
    }

    public String formatedSkills() {
        StringBuilder buf = new StringBuilder();
        for(int i = 0; i < this.skills.length; i++) {
            if(this.skills[i] != null) {
                buf.append(i + "=" + this.skills[i].getName() + ", ");
            }
        }
        return buf.toString();
    }

    public boolean isActive() {
        if(this.hitPoint <= 0) {
            return false;
        }
        return true;
    }


    /* Getter, Setter */

    public int getBlock() {
        return this.block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Skill[] getSkills() {
        return this.skills;
    }

    public String getTribeName() {
        return this.tribeName;
    }
}

