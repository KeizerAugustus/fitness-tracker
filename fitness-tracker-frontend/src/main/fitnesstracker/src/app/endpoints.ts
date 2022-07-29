export class Endpoints {
  private static basepath = "/fitnesstracker/api/v1/";

  static movements = Endpoints.basepath + "movements";
  static musclegroups = Endpoints.movements + "/musclegroups"
}
