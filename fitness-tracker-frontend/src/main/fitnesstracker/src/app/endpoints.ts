export class Endpoints {
  private static basepath = "/fitnesstracker/api/v1/";

  static movements = Endpoints.basepath + "movements";
  static musclegroups = Endpoints.movements + "/musclegroups";
  static workouttemplates = Endpoints.basepath + "workouttemplates";
  static workouttypes = Endpoints.workouttemplates + "/workouttypes"
}
