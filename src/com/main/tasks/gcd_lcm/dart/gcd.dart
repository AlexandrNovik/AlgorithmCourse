import 'dart:io';

Future<void> main() async {
  final lines = await File('../../../../../../numbers.txt').readAsLines();
  final a = lines.map((e) => int.parse(e)).first;
  final b = lines.map((e) => int.parse(e)).last;
  print(findGcd(a, b));
}

int findGcd(int a, int b) {
  if (a == 0) return b;
  if (b == 0) return a;
  return findGcd(b, a % b);
}
