# Mapeamento consolidado de texturas dos blocos

- Blocos analisados: **64**
- Classificações: `{"side": 31, "fixed_or_conditional": 25, "metadata": 2, "metadata_and_side": 1, "other": 5}`
- Blocos com campos dinâmicos: **2**
- Blocos com campos não resolvidos: **0**

> A seleção original foi preservada. Os números das faces seguem a convenção do código Java; a orientação equivalente no Bedrock ainda precisa ser validada.

---

## BlockAmmunition

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockAmmunition.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon3` | `"RivalRebels:aa"` | `RivalRebels:aa` | `textures/blocks/aa.png`, `textures/entity/aa.png`, `textures/items/aa.png` |
| `icon4` | `"RivalRebels:aa"` | `RivalRebels:aa` | `textures/blocks/aa.png`, `textures/entity/aa.png`, `textures/items/aa.png` |
| `icon5` | `"RivalRebels:aa"` | `RivalRebels:aa` | `textures/blocks/aa.png`, `textures/entity/aa.png`, `textures/items/aa.png` |
| `icon6` | `"RivalRebels:aa"` | `RivalRebels:aa` | `textures/blocks/aa.png`, `textures/entity/aa.png`, `textures/items/aa.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockAntimatterBomb

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockAntimatterBomb.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ak"` | `RivalRebels:ak` | `textures/blocks/ak.png`, `textures/entity/ak.png`, `textures/items/ak.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockAutoBarricade

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockAutoBarricade.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:cz"` | `RivalRebels:cz` | `textures/blocks/cz.png` |
| `icon2` | `"RivalRebels:da"` | `RivalRebels:da` | `textures/blocks/da.png` |
| `icon3` | `"RivalRebels:cx"` | `RivalRebels:cx` | `textures/blocks/cx.png` |
| `icon4` | `"RivalRebels:cx"` | `RivalRebels:cx` | `textures/blocks/cx.png` |
| `icon5` | `"RivalRebels:cx"` | `RivalRebels:cx` | `textures/blocks/cx.png` |
| `icon6` | `"RivalRebels:cx"` | `RivalRebels:cx` | `textures/blocks/cx.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockAutoBunker

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockAutoBunker.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon3` | `"RivalRebels:bl"` | `RivalRebels:bl` | `textures/blocks/bl.png`, `textures/entity/bl.png` |
| `icon4` | `"RivalRebels:bl"` | `RivalRebels:bl` | `textures/blocks/bl.png`, `textures/entity/bl.png` |
| `icon5` | `"RivalRebels:bl"` | `RivalRebels:bl` | `textures/blocks/bl.png`, `textures/entity/bl.png` |
| `icon6` | `"RivalRebels:bl"` | `RivalRebels:bl` | `textures/blocks/bl.png`, `textures/entity/bl.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockAutoEaster

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockAutoEaster.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon3` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon4` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockAutoForceField

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockAutoForceField.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:cz"` | `RivalRebels:cz` | `textures/blocks/cz.png` |
| `icon2` | `"RivalRebels:da"` | `RivalRebels:da` | `textures/blocks/da.png` |
| `icon3` | `"RivalRebels:db"` | `RivalRebels:db` | `textures/blocks/db.png` |
| `icon4` | `"RivalRebels:db"` | `RivalRebels:db` | `textures/blocks/db.png` |
| `icon5` | `"RivalRebels:db"` | `RivalRebels:db` | `textures/blocks/db.png` |
| `icon6` | `"RivalRebels:db"` | `RivalRebels:db` | `textures/blocks/db.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockAutoMarioTrap

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockAutoMarioTrap.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:dh"` | `RivalRebels:dh` | `textures/blocks/dh.png` |
| `icon2` | `"RivalRebels:dh"` | `RivalRebels:dh` | `textures/blocks/dh.png` |
| `icon3` | `"RivalRebels:de"` | `RivalRebels:de` | `textures/blocks/de.png` |
| `icon4` | `"RivalRebels:de"` | `RivalRebels:de` | `textures/blocks/de.png` |
| `icon5` | `"RivalRebels:de"` | `RivalRebels:de` | `textures/blocks/de.png` |
| `icon6` | `"RivalRebels:de"` | `RivalRebels:de` | `textures/blocks/de.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockAutoMineTrap

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockAutoMineTrap.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:dh"` | `RivalRebels:dh` | `textures/blocks/dh.png` |
| `icon2` | `"RivalRebels:dh"` | `RivalRebels:dh` | `textures/blocks/dh.png` |
| `icon3` | `"RivalRebels:df"` | `RivalRebels:df` | `textures/blocks/df.png` |
| `icon4` | `"RivalRebels:df"` | `RivalRebels:df` | `textures/blocks/df.png` |
| `icon5` | `"RivalRebels:df"` | `RivalRebels:df` | `textures/blocks/df.png` |
| `icon6` | `"RivalRebels:df"` | `RivalRebels:df` | `textures/blocks/df.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockAutoQuickSandTrap

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockAutoQuickSandTrap.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:dh"` | `RivalRebels:dh` | `textures/blocks/dh.png` |
| `icon2` | `"RivalRebels:dh"` | `RivalRebels:dh` | `textures/blocks/dh.png` |
| `icon3` | `"RivalRebels:dg"` | `RivalRebels:dg` | `textures/blocks/dg.png` |
| `icon4` | `"RivalRebels:dg"` | `RivalRebels:dg` | `textures/blocks/dg.png` |
| `icon5` | `"RivalRebels:dg"` | `RivalRebels:dg` | `textures/blocks/dg.png` |
| `icon6` | `"RivalRebels:dg"` | `RivalRebels:dg` | `textures/blocks/dg.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockAutoTower

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockAutoTower.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon3` | `"RivalRebels:cy"` | `RivalRebels:cy` | `textures/blocks/cy.png` |
| `icon4` | `"RivalRebels:cy"` | `RivalRebels:cy` | `textures/blocks/cy.png` |
| `icon5` | `"RivalRebels:cy"` | `RivalRebels:cy` | `textures/blocks/cy.png` |
| `icon6` | `"RivalRebels:cy"` | `RivalRebels:cy` | `textures/blocks/cy.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockBreadBox

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockBreadBox.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ca"` | `RivalRebels:ca` | `textures/blocks/ca.png`, `textures/entity/ca.png` |
| `icon2` | `"RivalRebels:cc"` | `RivalRebels:cc` | `textures/blocks/cc.png`, `textures/entity/cc.png` |
| `icon3` | `"RivalRebels:cb"` | `RivalRebels:cb` | `textures/blocks/cb.png`, `textures/entity/cb.png` |
| `icon4` | `"RivalRebels:ca"` | `RivalRebels:ca` | `textures/blocks/ca.png`, `textures/entity/ca.png` |
| `icon5` | `"RivalRebels:ca"` | `RivalRebels:ca` | `textures/blocks/ca.png`, `textures/entity/ca.png` |
| `icon6` | `"RivalRebels:ca"` | `RivalRebels:ca` | `textures/blocks/ca.png`, `textures/entity/ca.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockCamo1

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockCamo1.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:as"` | `RivalRebels:as` | `textures/blocks/as.png`, `textures/entity/as.png`, `textures/items/as.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockCamo2

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockCamo2.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:bn"` | `RivalRebels:bn` | `textures/blocks/bn.png`, `textures/entity/bn.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockCamo3

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockCamo3.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:by"` | `RivalRebels:by` | `textures/blocks/by.png`, `textures/entity/by.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockConduit

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockConduit.java`
- **Classificação:** `metadata`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:co"` | `RivalRebels:co` | `textures/blocks/co.png` |
| `icon2` | `"RivalRebels:cp"` | `RivalRebels:cp` | `textures/blocks/cp.png` |
| `icon3` | `"RivalRebels:cq"` | `RivalRebels:cq` | `textures/blocks/cq.png` |
| `icon4` | `"RivalRebels:cr"` | `RivalRebels:cr` | `textures/blocks/cr.png` |
| `icon5` | `"RivalRebels:cs"` | `RivalRebels:cs` | `textures/blocks/cs.png` |
| `icon6` | `"RivalRebels:ct"` | `RivalRebels:ct` | `textures/blocks/ct.png` |
| `icon7` | `"RivalRebels:cu"` | `RivalRebels:cu` | `textures/blocks/cu.png` |
| `icon8` | `"RivalRebels:cv"` | `RivalRebels:cv` | `textures/blocks/cv.png` |
| `icon9` | `"RivalRebels:cw"` | `RivalRebels:cw` | `textures/blocks/cw.png` |

### Lógica original de seleção

```java
if (meta == 1) {
         return this.icon1;
      } else if (meta == 2) {
         return this.icon2;
      } else if (meta == 3) {
         return this.icon3;
      } else if (meta == 4) {
         return this.icon4;
      } else if (meta == 5) {
         return this.icon5;
      } else if (meta == 6) {
         return this.icon6;
      } else if (meta == 7) {
         return this.icon7;
      } else if (meta == 8) {
         return this.icon8;
      } else {
         return meta == 9 ? this.icon9 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`, `icon7`, `icon8`, `icon9`

---

## BlockCycle

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockCycle.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ak"` | `RivalRebels:ak` | `textures/blocks/ak.png`, `textures/entity/ak.png`, `textures/items/ak.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockExplosives

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockExplosives.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon3` | `"RivalRebels:am"` | `RivalRebels:am` | `textures/blocks/am.png`, `textures/entity/am.png`, `textures/items/am.png` |
| `icon4` | `"RivalRebels:am"` | `RivalRebels:am` | `textures/blocks/am.png`, `textures/entity/am.png`, `textures/items/am.png` |
| `icon5` | `"RivalRebels:am"` | `RivalRebels:am` | `textures/blocks/am.png`, `textures/entity/am.png`, `textures/items/am.png` |
| `icon6` | `"RivalRebels:am"` | `RivalRebels:am` | `textures/blocks/am.png`, `textures/entity/am.png`, `textures/items/am.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockFlag

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockFlag.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `this.texpath` | `Dinâmica` | — |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

**Campos dinâmicos:** `icon`

---

## BlockFlagBox1

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockFlagBox1.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:bi"` | `RivalRebels:bi` | `textures/blocks/bi.png`, `textures/entity/bi.png`, `textures/items/bi.png` |
| `icon3` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon4` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockFlagBox3

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockFlagBox3.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ar"` | `RivalRebels:ar` | `textures/blocks/ar.png`, `textures/entity/ar.png`, `textures/items/ar.png` |
| `icon3` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon4` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockFlagBox4

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockFlagBox4.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:aw"` | `RivalRebels:aw` | `textures/blocks/aw.png`, `textures/entity/aw.png`, `textures/items/aw.png` |
| `icon3` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon4` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockFlagBox5

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockFlagBox5.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:aq"` | `RivalRebels:aq` | `textures/blocks/aq.png`, `textures/entity/aq.png`, `textures/items/aq.png` |
| `icon3` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon4` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockFlagBox6

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockFlagBox6.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:al"` | `RivalRebels:al` | `textures/blocks/al.png`, `textures/entity/al.png`, `textures/items/al.png` |
| `icon3` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon4` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockFlagBox7

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockFlagBox7.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:aj"` | `RivalRebels:aj` | `textures/blocks/aj.png`, `textures/entity/aj.png` |
| `icon3` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon4` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockFlare

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockFlare.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:an"` | `RivalRebels:an` | `textures/blocks/an.png`, `textures/entity/an.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockForceField

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockForceField.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:di"` | `RivalRebels:di` | `textures/blocks/di.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockForceFieldNode

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockForceFieldNode.java`
- **Classificação:** `metadata_and_side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:cf"` | `RivalRebels:cf` | `textures/blocks/cf.png`, `textures/entity/cf.png` |
| `icon2` | `"RivalRebels:cg"` | `RivalRebels:cg` | `textures/blocks/cg.png`, `textures/entity/cg.png` |
| `icontop1` | `"RivalRebels:cj"` | `RivalRebels:cj` | `textures/blocks/cj.png`, `textures/entity/cj.png` |
| `icontop2` | `"RivalRebels:ck"` | `RivalRebels:ck` | `textures/blocks/ck.png`, `textures/entity/ck.png` |
| `icontop3` | `"RivalRebels:cl"` | `RivalRebels:cl` | `textures/blocks/cl.png` |
| `icontop4` | `"RivalRebels:cm"` | `RivalRebels:cm` | `textures/blocks/cm.png` |

### Lógica original de seleção

```java
if (meta == 0) {
         if (side == 0 || side == 1) {
            return this.icontop2;
         } else {
            return side == 4 ? this.icon2 : this.icon;
         }
      } else if (side != 0 && side != 1) {
         return side == meta ? this.icon2 : this.icon;
      } else {
         return meta == 3 ? this.icontop1 : (meta == 4 ? this.icontop2 : (meta == 2 ? this.icontop3 : this.icontop4));
      }
```

**Campos utilizados:** `icon`, `icon2`, `icontop1`, `icontop2`, `icontop3`, `icontop4`

---

## BlockForceShield

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockForceShield.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ao"` | `RivalRebels:ao` | `textures/blocks/ao.png`, `textures/entity/ao.png`, `textures/items/ao.png` |
| `icon2` | `"RivalRebels:ap"` | `RivalRebels:ap` | `textures/blocks/ap.png`, `textures/entity/ap.png`, `textures/items/ap.png` |

### Lógica original de seleção

```java
return side != 0 && side != 1 ? this.icon1 : this.icon2;
```

**Campos utilizados:** `icon1`, `icon2`

---

## BlockGameStart

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockGameStart.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon3` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon4` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockGore

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockGore.java`
- **Classificação:** `metadata`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:br"` | `RivalRebels:br` | `textures/blocks/br.png`, `textures/entity/br.png` |
| `icon2` | `"RivalRebels:bs"` | `RivalRebels:bs` | `textures/blocks/bs.png`, `textures/entity/bs.png` |
| `icon3` | `"RivalRebels:bt"` | `RivalRebels:bt` | `textures/blocks/bt.png`, `textures/entity/bt.png` |
| `icon4` | `"RivalRebels:bu"` | `RivalRebels:bu` | `textures/blocks/bu.png`, `textures/entity/bu.png` |
| `icon5` | `"RivalRebels:bv"` | `RivalRebels:bv` | `textures/blocks/bv.png`, `textures/entity/bv.png` |
| `icon6` | `"RivalRebels:bw"` | `RivalRebels:bw` | `textures/blocks/bw.png`, `textures/entity/bw.png` |

### Lógica original de seleção

```java
if (meta == 0) {
         return this.icon;
      } else if (meta == 1) {
         return this.icon2;
      } else if (meta == 2) {
         return this.icon3;
      } else if (meta == 3) {
         return this.icon4;
      } else if (meta == 4) {
         return this.icon5;
      } else {
         return meta == 5 ? this.icon6 : this.icon;
      }
```

**Campos utilizados:** `icon`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockJump

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockJump.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:au"` | `RivalRebels:au` | `textures/blocks/au.png`, `textures/entity/au.png`, `textures/items/au.png` |
| `icon3` | `"RivalRebels:at"` | `RivalRebels:at` | `textures/blocks/at.png`, `textures/entity/at.png`, `textures/items/at.png` |
| `icon4` | `"RivalRebels:at"` | `RivalRebels:at` | `textures/blocks/at.png`, `textures/entity/at.png`, `textures/items/at.png` |
| `icon5` | `"RivalRebels:at"` | `RivalRebels:at` | `textures/blocks/at.png`, `textures/entity/at.png`, `textures/items/at.png` |
| `icon6` | `"RivalRebels:at"` | `RivalRebels:at` | `textures/blocks/at.png`, `textures/entity/at.png`, `textures/items/at.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockLandMine

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockLandMine.java`
- **Classificação:** `other`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| — | — | — | — |

### Lógica original de seleção

```java
return Blocks.field_150349_c.func_149691_a(side, meta);
```

**Campos utilizados:** Nenhum

---

## BlockLaptop

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockLaptop.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:dc"` | `RivalRebels:dc` | `textures/blocks/dc.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockLight

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockLight.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ad"` | `RivalRebels:ad` | `textures/blocks/ad.png`, `textures/entity/ad.png`, `textures/items/ad.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockLoader

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockLoader.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:av"` | `RivalRebels:av` | `textures/blocks/av.png`, `textures/entity/av.png`, `textures/items/av.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockMario

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockMario.java`
- **Classificação:** `other`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| — | — | — | — |

### Lógica original de seleção

```java
return this == RivalRebels.amario ? Blocks.field_150351_n.func_149691_a(side, meta) : Blocks.field_150349_c.func_149691_a(side, meta);
```

**Campos utilizados:** Nenhum

---

## BlockMeltDown

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockMeltDown.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ak"` | `RivalRebels:ak` | `textures/blocks/ak.png`, `textures/entity/ak.png`, `textures/items/ak.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockNuclearBomb

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockNuclearBomb.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ak"` | `RivalRebels:ak` | `textures/blocks/ak.png`, `textures/entity/ak.png`, `textures/items/ak.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockNukeCrate

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockNukeCrate.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ax"` | `RivalRebels:ax` | `textures/blocks/ax.png`, `textures/entity/ax.png`, `textures/items/ax.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockOmegaArmor

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockOmegaArmor.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon3` | `"RivalRebels:az"` | `RivalRebels:az` | `textures/blocks/az.png`, `textures/entity/az.png`, `textures/items/az.png` |
| `icon4` | `"RivalRebels:az"` | `RivalRebels:az` | `textures/blocks/az.png`, `textures/entity/az.png`, `textures/items/az.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockOmegaObjective

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockOmegaObjective.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ba"` | `RivalRebels:ba` | `textures/blocks/ba.png`, `textures/entity/ba.png`, `textures/items/ba.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockPetrifiedStone

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockPetrifiedStone.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:b" + this.type` | `Dinâmica` | — |
| `icon2` | `"RivalRebels:b" + this.type` | `Dinâmica` | — |
| `icon3` | `"RivalRebels:bb"` | `RivalRebels:bb` | `textures/blocks/bb.png`, `textures/entity/bb.png`, `textures/items/bb.png` |
| `icon4` | `"RivalRebels:bb"` | `RivalRebels:bb` | `textures/blocks/bb.png`, `textures/entity/bb.png`, `textures/items/bb.png` |
| `icon5` | `"RivalRebels:bb"` | `RivalRebels:bb` | `textures/blocks/bb.png`, `textures/entity/bb.png`, `textures/items/bb.png` |
| `icon6` | `"RivalRebels:bb"` | `RivalRebels:bb` | `textures/blocks/bb.png`, `textures/entity/bb.png`, `textures/items/bb.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

**Campos dinâmicos:** `icon1`, `icon2`

---

## BlockPetrifiedWood

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockPetrifiedWood.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:bh"` | `RivalRebels:bh` | `textures/blocks/bh.png`, `textures/entity/bh.png`, `textures/items/bh.png` |
| `icon2` | `"RivalRebels:bh"` | `RivalRebels:bh` | `textures/blocks/bh.png`, `textures/entity/bh.png`, `textures/items/bh.png` |
| `icon3` | `"RivalRebels:bg"` | `RivalRebels:bg` | `textures/blocks/bg.png`, `textures/entity/bg.png`, `textures/items/bg.png` |
| `icon4` | `"RivalRebels:bg"` | `RivalRebels:bg` | `textures/blocks/bg.png`, `textures/entity/bg.png`, `textures/items/bg.png` |
| `icon5` | `"RivalRebels:bg"` | `RivalRebels:bg` | `textures/blocks/bg.png`, `textures/entity/bg.png`, `textures/items/bg.png` |
| `icon6` | `"RivalRebels:bg"` | `RivalRebels:bg` | `textures/blocks/bg.png`, `textures/entity/bg.png`, `textures/items/bg.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockPlasmaExplosion

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockPlasmaExplosion.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ak"` | `RivalRebels:ak` | `textures/blocks/ak.png`, `textures/entity/ak.png`, `textures/items/ak.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockQuickSand

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockQuickSand.java`
- **Classificação:** `other`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| — | — | — | — |

### Lógica original de seleção

```java
return this == RivalRebels.aquicksand ? Blocks.field_150354_m.func_149691_a(side, meta) : Blocks.field_150349_c.func_149691_a(side, meta);
```

**Campos utilizados:** Nenhum

---

## BlockRadioactiveDirt

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockRadioactiveDirt.java`
- **Classificação:** `other`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| — | — | — | — |

### Lógica original de seleção

```java
return Blocks.field_150346_d.func_149691_a(side, meta);
```

**Campos utilizados:** Nenhum

---

## BlockRadioactiveSand

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockRadioactiveSand.java`
- **Classificação:** `other`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| — | — | — | — |

### Lógica original de seleção

```java
return Blocks.field_150354_m.func_149691_a(side, meta);
```

**Campos utilizados:** Nenhum

---

## BlockReactive

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockReactive.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:cf"` | `RivalRebels:cf` | `textures/blocks/cf.png`, `textures/entity/cf.png` |
| `icontop` | `"RivalRebels:cn"` | `RivalRebels:cn` | `textures/blocks/cn.png` |

### Lógica original de seleção

```java
return side != 0 && side != 1 ? this.icon : this.icontop;
```

**Campos utilizados:** `icon`, `icontop`

---

## BlockReactor

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockReactor.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:bj"` | `RivalRebels:bj` | `textures/blocks/bj.png`, `textures/entity/bj.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockReciever

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockReciever.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:dj"` | `RivalRebels:dj` | `textures/blocks/dj.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockRemoteCharge

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockRemoteCharge.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ag"` | `RivalRebels:ag` | `textures/blocks/ag.png`, `textures/entity/ag.png`, `textures/items/ag.png` |
| `icon2` | `"RivalRebels:ag"` | `RivalRebels:ag` | `textures/blocks/ag.png`, `textures/entity/ag.png`, `textures/items/ag.png` |
| `icon3` | `"RivalRebels:af"` | `RivalRebels:af` | `textures/blocks/af.png`, `textures/entity/af.png`, `textures/items/af.png` |
| `icon4` | `"RivalRebels:af"` | `RivalRebels:af` | `textures/blocks/af.png`, `textures/entity/af.png`, `textures/items/af.png` |
| `icon5` | `"RivalRebels:af"` | `RivalRebels:af` | `textures/blocks/af.png`, `textures/entity/af.png`, `textures/items/af.png` |
| `icon6` | `"RivalRebels:af"` | `RivalRebels:af` | `textures/blocks/af.png`, `textures/entity/af.png`, `textures/items/af.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockRhodesActivator

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockRhodesActivator.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ci"` | `RivalRebels:ci` | `textures/blocks/ci.png`, `textures/entity/ci.png` |
| `icontop` | `"RivalRebels:ch"` | `RivalRebels:ch` | `textures/blocks/ch.png`, `textures/entity/ch.png` |

### Lógica original de seleção

```java
return side != 0 && side != 1 ? this.icon : this.icontop;
```

**Campos utilizados:** `icon`, `icontop`

---

## BlockRhodesScaffold

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/autobuilds/BlockRhodesScaffold.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:cz"` | `RivalRebels:cz` | `textures/blocks/cz.png` |
| `icon2` | `"RivalRebels:da"` | `RivalRebels:da` | `textures/blocks/da.png` |
| `icon3` | `"RivalRebels:dk"` | `RivalRebels:dk` | `textures/blocks/dk.png` |
| `icon4` | `"RivalRebels:dk"` | `RivalRebels:dk` | `textures/blocks/dk.png` |
| `icon5` | `"RivalRebels:dk"` | `RivalRebels:dk` | `textures/blocks/dk.png` |
| `icon6` | `"RivalRebels:dk"` | `RivalRebels:dk` | `textures/blocks/dk.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockSigmaArmor

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockSigmaArmor.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon3` | `"RivalRebels:bo"` | `RivalRebels:bo` | `textures/blocks/bo.png`, `textures/entity/bo.png` |
| `icon4` | `"RivalRebels:bo"` | `RivalRebels:bo` | `textures/blocks/bo.png`, `textures/entity/bo.png` |
| `icon5` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon6` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockSigmaObjective

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/machine/BlockSigmaObjective.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:bp"` | `RivalRebels:bp` | `textures/blocks/bp.png`, `textures/entity/bp.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockSmartCamo

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockSmartCamo.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:bq"` | `RivalRebels:bq` | `textures/blocks/bq.png`, `textures/entity/bq.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockSteel

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/BlockSteel.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:bx"` | `RivalRebels:bx` | `textures/blocks/bx.png`, `textures/entity/bx.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockSupplies

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockSupplies.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon3` | `"RivalRebels:bz"` | `RivalRebels:bz` | `textures/blocks/bz.png`, `textures/entity/bz.png` |
| `icon4` | `"RivalRebels:bz"` | `RivalRebels:bz` | `textures/blocks/bz.png`, `textures/entity/bz.png` |
| `icon5` | `"RivalRebels:bz"` | `RivalRebels:bz` | `textures/blocks/bz.png`, `textures/entity/bz.png` |
| `icon6` | `"RivalRebels:bz"` | `RivalRebels:bz` | `textures/blocks/bz.png`, `textures/entity/bz.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockTachyonBomb

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockTachyonBomb.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ak"` | `RivalRebels:ak` | `textures/blocks/ak.png`, `textures/entity/ak.png`, `textures/items/ak.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockTheoreticalTsarBomba

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockTheoreticalTsarBomba.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ak"` | `RivalRebels:ak` | `textures/blocks/ak.png`, `textures/entity/ak.png`, `textures/items/ak.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockTimedBomb

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockTimedBomb.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ac"` | `RivalRebels:ac` | `textures/blocks/ac.png`, `textures/entity/ac.png`, `textures/items/ac.png` |
| `icon2` | `"RivalRebels:ae"` | `RivalRebels:ae` | `textures/blocks/ae.png`, `textures/entity/ae.png`, `textures/items/ae.png` |
| `icon3` | `"RivalRebels:ac"` | `RivalRebels:ac` | `textures/blocks/ac.png`, `textures/entity/ac.png`, `textures/items/ac.png` |
| `icon4` | `"RivalRebels:ac"` | `RivalRebels:ac` | `textures/blocks/ac.png`, `textures/entity/ac.png`, `textures/items/ac.png` |
| `icon5` | `"RivalRebels:ab"` | `RivalRebels:ab` | `textures/blocks/ab.png`, `textures/entity/ab.png`, `textures/items/ab.png` |
| `icon6` | `"RivalRebels:ab"` | `RivalRebels:ab` | `textures/blocks/ab.png`, `textures/entity/ab.png`, `textures/items/ab.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

---

## BlockToxicGas

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockToxicGas.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ak"` | `RivalRebels:ak` | `textures/blocks/ak.png`, `textures/entity/ak.png`, `textures/items/ak.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockTsarBomba

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/trap/BlockTsarBomba.java`
- **Classificação:** `fixed_or_conditional`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon` | `"RivalRebels:ak"` | `RivalRebels:ak` | `textures/blocks/ak.png`, `textures/entity/ak.png`, `textures/items/ak.png` |

### Lógica original de seleção

```java
return this.icon;
```

**Campos utilizados:** `icon`

---

## BlockWeapons

- **Arquivo:** `decompiled/assets/rivalrebels/common/block/crate/BlockWeapons.java`
- **Classificação:** `side`

### Texturas registradas

| Campo | Expressão Java | Textura literal | Arquivos encontrados |
|---|---|---|---|
| `icon1` | `"RivalRebels:ah"` | `RivalRebels:ah` | `textures/blocks/ah.png`, `textures/entity/ah.png`, `textures/items/ah.png` |
| `icon2` | `"RivalRebels:ai"` | `RivalRebels:ai` | `textures/blocks/ai.png`, `textures/entity/ai.png`, `textures/items/ai.png` |
| `icon3` | `"RivalRebels:ce"` | `RivalRebels:ce` | `textures/blocks/ce.png`, `textures/entity/ce.png` |
| `icon4` | `"RivalRebels:ce"` | `RivalRebels:ce` | `textures/blocks/ce.png`, `textures/entity/ce.png` |
| `icon5` | `"RivalRebels:ce"` | `RivalRebels:ce` | `textures/blocks/ce.png`, `textures/entity/ce.png` |
| `icon6` | `"RivalRebels:ce"` | `RivalRebels:ce` | `textures/blocks/ce.png`, `textures/entity/ce.png` |

### Lógica original de seleção

```java
if (side == 0) {
         return this.icon1;
      } else if (side == 1) {
         return this.icon2;
      } else if (side == 2) {
         return this.icon3;
      } else if (side == 3) {
         return this.icon4;
      } else if (side == 4) {
         return this.icon5;
      } else {
         return side == 5 ? this.icon6 : this.icon1;
      }
```

**Campos utilizados:** `icon1`, `icon2`, `icon3`, `icon4`, `icon5`, `icon6`

