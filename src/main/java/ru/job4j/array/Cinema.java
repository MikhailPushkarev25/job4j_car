package ru.job4j.array;

import java.util.Objects;

public class Cinema {

    public static Place checkEmptyPlace(Place[][] places) {

        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {
                Place place = new Place(i, j);
                Place one = null;
                Place two = null;
                Place three = null;
                Place four = null;

                if(i - 1 >= 0) {
                    one = places[i - 1][j];
                }
                if (i + 1 != places.length) {
                    two = places[i + 1][j];
                }
                if (j - 1 >= 0) {
                    three = places[i][j - 1];
                }
                if (j + 1 != places[i].length) {
                    four = places[i][j + 1];
                }
                if (place == null) {
                    if (one == null && two == null && three == null && four == null) {
                        return new Place(i, j);
                    }
                }
            }
        }
        return null;
    }

    public static class Place {
        private int row;
        private int cell;

        public Place(int row, int cell) {
            this.row = row;
            this.cell = cell;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Place place = (Place) o;
            return row == place.row &&
                    cell == place.cell;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, cell);
        }
    }
}
